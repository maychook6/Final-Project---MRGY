pipeline {
    agent any

    stages {
        stage('Deploy') {
            steps {
                sh 'cp -R OurApp ~/Downloads/apache-tomcat-8.5.92/webapps'
            }
        }

        stage('Selenium') {
            steps {
                //Run converted Selenium IDE recording to python pytest
                // Selenium IDE -> Record test -> Click Export -> Choose python -> Run converted recording file with pytest
            }
        }

        stage('Load Test') {
            steps {
               
            }
        }

        stage('Stress Test') {
            steps {
                
            }
        }
    }
}