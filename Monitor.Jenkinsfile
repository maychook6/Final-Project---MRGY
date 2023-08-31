pipeline {
    agent any

    stages {
        stage('Monitor') {
            steps {
                script {
                    sh 'curl -I -s -o output.txt http://localhost:8000/OurApp/'

                    def statusCode = sh(script: 'grep "200" output.txt', returnStatus: true)

                    if (statusCode != 0) {
                        sh "exit 1"
                    }
                }
            }
        }
    }
}