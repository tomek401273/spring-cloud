def getSwarmNetworkIp() {
    def proc = "docker inspect springcloud-overlay".execute()
    def result = proc.text
    def ipWithQuotes = (result =~ /IP": "(\d+[.]){3}\d+"/)
    def ip;
    if (ipWithQuotes) ip = (ipWithQuotes.group() =~ /(\d+[.]){3}\d+/)
    if (ip) return ip.group();
}


def checkServerAvailability(ip) {
    def get = new URL("http://"+ip+":8888/limits-service/default").openConnection();
    try {
        def getRC = get.getResponseCode();
        if (getRC.equals(200))
            return true
        else return false

    } catch (Exception e) {
        return false;
    }

}

node('build_node') {
    stage('pull') {
        git 'https://github.com/tomek401273/spring-cloud'
    }
    stage('package-repository') {
        sh script: 'mvn -f ./cloud-repository/ clean package'
    }
    stage('package-auth') {
        sh script: 'mvn -f ./authorization-service/ clean  package'
    }

    stage('package-eureka') {
        sh script: 'mvn -f ./eureka-naming-service/ clean  package'
    }

    stage('package-config') {
        sh script: 'mvn -f ./spring-cloud-config-server/ clean  package'
    }

    stage('package-zuul') {
        sh script: 'mvn -f ./zuul-server/ clean  package'
    }
    stage('docker-repository') {
        sh script: 'docker build -t tomek371240/repository:1.0 ./cloud-repository/'
    }
    stage('docker-postgres') {
        sh script: 'docker build -t tomek371240/postgres:1 ./spring-cloud-config-server/postgres/'
    }
    stage('docker-auth') {
        sh script: 'docker build -t tomek371240/authorization:5.0 ./authorization-service/'
    }
    stage('docker-eureka') {
        sh script: 'docker build -t tomek371240/netflix-eureka-naming-server:5.0 ./eureka-naming-service/'
    }
    stage('docker-nginx') {
        sh script: 'docker build -t tomek371240/nginx:5.0 ./nginx/'
    }
    stage('docker-config') {
        sh script: 'docker build -t tomek371240/config-server:5.0 ./spring-cloud-config-server/'
    }
    stage ('docker-zuul') {
        sh script: 'docker build -t tomek371240/netflix-zuul-api-gateway-server:5.0 ./zuul-server/'
    }
    stage ('swarm-pre-stack') {
        sh script: 'docker stack deploy -c ./spring-cloud-config-server/compose/pre-containers.yml pre_stack'
    }
    stage('first') {

        def isAvailable = false;
        int i = 0

        while (!isAvailable && i < 50) {
            i++;
            def ip =getSwarmNetworkIp();
            println ip
            if (ip != null) {
                isAvailable = checkServerAvailability(ip);
            }
            println('attempt: ' + i + isAvailable)
            Thread.sleep(5*1000);
        }

        if (isAvailable) sh script: 'docker stack deploy -c ./spring-cloud-config-server/compose/docker-compose.yml main_stack'
        if (!isAvailable) println 'config server was not ready in 10 seconds!!!'
    }
}
