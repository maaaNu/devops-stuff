pipeline {
    agent any 
    stages {
        stage('install') {
            steps {
                sh 'ansible all -m ping'
            }
        }
    }
}