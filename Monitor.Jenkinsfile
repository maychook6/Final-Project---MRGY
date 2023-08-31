pipeline {
    agent any

    stages {
        stage('Monitor') {
             steps {
                script {
                    def statusCode = sh('grep "200" output.txt', returnStatus: true)
                    if (statusCode == '200') {
                        sh 'curl -I -s -o output.txt http://localhost:8000/OurApp/'
                    } else {
                        sh 'exit 1'
                    }

                }
                
            }
        }
     }
 }