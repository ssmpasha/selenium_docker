pipeline{
    agent any

    stages{
        stage('Build Jar'){
            steps{
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Generate Image'){
            steps{
                bat "docker build -t=shahidsyed99/selenium ."
            }
         }
        stage('Push Image'){
            environment{
                DOCKER_HUB = credentials('dockerhub-creds')
            }
           steps{
                bat 'docker login -u %DOCKER_HUB_USR% -p %DOCKER_HUB_PSW%'
                bat "docker push shahidsyed99/selenium:latest"
                bat "docker tag shahidsyed99/selenium:latest shahidsyed99/selenium:${env.BUILD_NUMBER}"
                bat "docker push shahidsyed99/selenium:${env.BUILD_NUMBER}"
            }
         }
    }
    post{
        always{
            bat "docker logout"
        }
    }
}