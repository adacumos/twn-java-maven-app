#!/user/bin/env groovy

@Library('jenkins-shared-library')_

pipeline {   
    agent any
    tools {
        maven 'maven-3.9'
    }
    stages {
        stage("build jar") {
            steps {
                script {
                    buildJar()
                }
            }
        }

        stage("build docker image") {
            steps {
                script {
                    builImage()
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    deployApp()
                }
            }
        }               
    }
} 
