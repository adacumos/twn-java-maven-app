def buildJar() {
    echo "Building the application...."
    sh 'mvn clean package'
}

def buildDockerImage() {
    echo "Building the docker image...."
    withCredentials([usernamePassword(credentialsId: 'dockerhub', 
    usernameVariable: 'USER', 
    passwordVariable: 'PASS')]) {
        sh 'echo ${PASS} | docker login -u ${USER} --password-stdin'
        sh 'docker build -t ${DOCKER_IMAGE} .'
        sh 'docker push ${DOCKER_IMAGE}'
    }
}

def deploy() {
    echo "Deploying the application...."
}