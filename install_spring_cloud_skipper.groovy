pipeline {
    agent any 
    stages {
        stage('install') {
            steps {
                sh 'echo Hello World'
            }
        }
    }
}