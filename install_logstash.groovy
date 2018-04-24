pipeline {
    agent any
        stages {
            stage('Install: jdk') {
                steps {
                    sh 'ansible es -b -m yum -a "name=java-1.8.0-openjdk state=installed"'
                }
            }
            stage('Download: logstash'){
                steps {
                    sh 'ansible es -m file -a "path=~/install_tmp/ state=directory"'
                    sh 'ansible es -m get_url "-a url=https://artifacts.elastic.co/downloads/logstash/logstash-6.2.4.rpm dest=~/install_tmp/"'
                    sh 'ansible es -m get_url "-a url=https://artifacts.elastic.co/downloads/logstash/logstash-6.2.4.rpm.sha512 dest=~/install_tmp/"'
                    sh 'ansible es -m shell -a "cd ~/install_tmp/;sha512sum -c logstash-6.2.4.rpm.sha512"'
                    sh 'ansible es -m shell -a "cd ~/install_tmp/;sudo rpm --install logstash-6.2.4.rpm"'
                    sh 'ansible es -m shell -b -a "systemctl start logstash.service"'
                }
            }
        }
}