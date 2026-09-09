pipeline {   
    agent any
    tools {
        maven 'maven-3.9'
    }
    environment {
        DOCKER_IMAGE = "adacumos/twn-bootcamp-repo:java-maven-app-1.1"
    }
    stages {
        stage("build jar") {
            steps {
                script {
                    echo "Building the application...."
                    sh 'mvn clean package'
                }
            }
        }

        stage("build docker image") {
            steps {
                script {
                    echo "Building the docker image...."
                    withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                        sh 'echo ${PASS} | docker login -u ${USER} --password-stdin'
                        sh 'docker build -t ${DOCKER_IMAGE} .'
                        sh 'docker push ${DOCKER_IMAGE}'
                    }
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    echo "Deploying the application...."
                }
            }
        }               
    }
} 
