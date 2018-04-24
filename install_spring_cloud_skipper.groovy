pipeline {
    agent any 
    stages {
        stage('install') {
            steps {
                powershell "curl www.google.de"
            }
        }
    }
}