pipeline {
    agent any
        stages {
            stage('Install: jdk') {
                steps {
                    sh 'ansible es -b -m yum -a "name=java-1.8.0-openjdk state=installed"'
                }
            }
            stage('Download: elasticsearch'){
                steps {
                    sh 'ansible es -m file -a "path=~/install_tmp/ state=directory"'
                    sh 'ansible es -m get_url "-a url=https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-6.2.4.rpm dest=~/install_tmp/"'
                    sh 'ansible es -m get_url "-a url=https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-6.2.4.rpm.sha512 dest=~/install_tmp/"'
                    sh 'ansible es -m shell -a "cd ~/install_tmp/;sha512sum -c elasticsearch-6.2.4.rpm.sha512"'
                    sh 'ansible es -m shell -a "cd ~/install_tmp/;rpm --install elasticsearch-6.2.4.rpm"'
                    sh 'ansible es -m shell -b -a "systemctl start elasticsearch.service"'
                }
            }
        }
}