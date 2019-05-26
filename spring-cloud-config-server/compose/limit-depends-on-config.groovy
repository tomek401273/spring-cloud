stage('pull') {
    git 'https://github.com/tomek401273/spring-cloud'
}


def checkServerAvailability() {
    def get = new URL("http://192.168.42.101:8888/limits-service/default").openConnection();
    try {
        def getRC = get.getResponseCode();
        if (getRC.equals(200))
            return true
        else return false

    } catch (Exception e) {
        return false;
    }

}


node('master') {
    stage('pull') {
        git 'https://github.com/tomek401273/spring-cloud'
    }
    stage('package-config') {
        sh script: 'mvn -f ./spring-cloud-config-server/ package'
    }
    stage('package-limit') {
        sh script: 'mvn -f ./limit-service/ package'
    }
    stage('docker-limit') {
        sh script: 'docker build -t tomek371240/limit-service:5.0 ./limit-service/'
    }
    stage('docker-config') {
        sh script: 'docker build -t tomek371240/config-server:5.0 ./spring-cloud-config-server/'
    }
    stage ('swarm-pre-stack') {
        sh script: 'docker stack deploy -c ./spring-cloud-config-server/compose2/config-server.yml config_stack'
    }
    stage('first') {

        def isAvailable = false;
        int i = 0

        while (!isAvailable && i < 5) {
            i++;
            isAvailable = checkServerAvailability();
            println('attempt: ' + i + isAvailable)
            Thread.sleep(2*1000);
        }
        if (isAvailable) sh script: 'docker stack deploy -c ./spring-cloud-config-server/compose2/limit-server.yml limit_stack'

        if (!isAvailable) println 'config server was not ready in 10 seconds!!!'
    }
}
