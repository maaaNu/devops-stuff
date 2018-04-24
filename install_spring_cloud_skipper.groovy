pipeline {
    agent any 
    stages {
        stage('install') {
            steps {
                batch sh "echo Hello World"
            }
        }
    }
}