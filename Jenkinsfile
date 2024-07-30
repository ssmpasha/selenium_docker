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
           steps{
                bat "docker push shahidsyed99/selenium"
            }
         }
    }
}