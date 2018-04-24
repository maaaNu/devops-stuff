pipeline {
    agent any 
    stages {
        stage('Install: jdk') {
            steps {
                sh 'ansible all -b -m yum -a "name=java-1.8.0-openjdk state=installed"'
            }
        }
        stage('Create: directories'){
            steps {
                sh 'ansible all -m file -a "path=~/install_tmp/ state=directory"'
            }
        }
        stage('Download: Spring-Cloud-Skipper'){
            steps {
                sh 'ansible all -m get_url "-a url=http://repo.spring.io/snapshot/org/springframework/cloud/spring-cloud-skipper-server/1.0.3.BUILD-SNAPSHOT/spring-cloud-skipper-server-1.0.3.BUILD-SNAPSHOT.jar dest=~/install_tmp/spring-cloud-skipper.jar"'
            }
        }
        stage('Execute: Spring-Cloud-Skipper'){
            steps {
                sh 'ansible all -m shell -a "cd ~/install_tmp/;java -jar spring-cloud-skipper.jar"'
            }
        }
    }
}