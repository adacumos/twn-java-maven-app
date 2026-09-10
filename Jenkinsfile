def pipelineUtils 

pipeline {   
    agent any
    tools {
        maven 'maven-3.9'
    }
    environment {
        DOCKER_IMAGE = "adacumos/twn-bootcamp-repo:java-maven-app-1.1"
    }
    stages {
        stage('initialize') {
            steps {
                script {
                    pipelineUtils = load 'pipelineUtils.groovy'
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    pipelineUtils.buildJar()
                }
            }
        }

        stage("build docker image") {
            steps {
                script {
                    pipelineUtils.buildDockerImage()
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    pipelineUtils.deploy()
                }
            }
        }               
    }
} 
