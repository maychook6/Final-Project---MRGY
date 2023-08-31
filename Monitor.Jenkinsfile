pipeline {
    agent any

    stages {
        stage('Monitor') {
             steps {
                script {
                    if (runShell('grep "200" output.txt' == '200')) {
                        sh 'curl -I -s -o output.txt http://localhost:8000/OurApp/'
                    } else {
                        sh 'exit 1'
                    }

                }
                
            }
        }
     }
 }