pipeline {
    agent any 
    stages {
        stage('install') {
            steps {
                bat 'sh echo Hello World'
            }
        }
    }
}