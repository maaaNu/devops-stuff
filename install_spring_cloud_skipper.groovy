pipeline {
    agent any 
    stages {
        stage('install') {
            steps {
                bat(returnStdout: true, script: "sh 'ansible all -m ping'")
            }
        }
    }
}