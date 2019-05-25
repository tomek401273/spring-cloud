node ('master') {
    stage('pull') {
        git 'https://github.com/tomek401273/spring-cloud'
    }
    stage('package-repository') {
        sh script: 'mvn -f ./cloud-repository/ package'
    }
    stage('package-auth') {
        sh script: 'mvn -f ./authorization-service/ package'
    }
    stage('package-conversion') {
        sh script: 'mvn -f ./currency-conversion-service/ package'
    }
    stage('package-exchange') {
        sh script: 'mvn -f ./currency-exchange-service/ package'
    }
    stage('package-eureka') {
        sh script: 'mvn -f ./eureka-naming-service/ package'
    }

    stage('package-limit') {
        sh script: 'mvn -f ./limit-service/ package'
    }
    stage('package-config') {
        sh script: 'mvn -f ./spring-cloud-config-server/ package'
    }

    stage('package-zuul') {
        sh script: 'mvn -f ./zuul-server/ package'
    }
    stage('docker-repository') {
        sh script: 'docker build -t tomek371240/repository:1.0 ./cloud-repository/'
    }
    stage('docker-auth') {
        sh script: 'docker build -t tomek371240/authorization:5.0 ./authorization-service/'
    }
    stage('docker-conversion') {
        sh script: 'docker build -t tomek371240/currency-conversion-service:5.0 ./currency-conversion-service/'
    }
    stage('docker-exchange') {
        sh script: 'docker build -t tomek371240/currency-exchange-service:5.0 ./currency-exchange-service/'
    }
    stage('docker-eureka') {
        sh script: 'docker build -t tomek371240/netflix-eureka-naming-server:5.0 ./eureka-naming-service/'
    }
    stage('docker-limit') {
        sh script: 'docker build -t tomek371240/limit-service:5.0 ./limit-service/'
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
    stage('swarm-main-stack') {
        sh script: 'docker stack deploy -c ./spring-cloud-config-server/compose/docker-compose.yml pre_stack'
    }

}
