pipeline {
    agent any 
    stages {
        stage('install') {
            steps {
                sh """#!/bin/bash   
                echo hello world"""
            }
        }
    }
}