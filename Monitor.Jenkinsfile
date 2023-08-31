pipeline {
    agent any

    stages {
        stage('Monitor') {
            steps {
                script {
                    def statusCode = sh(script: 'grep "200" output.txt', returnStatus: true)
                    if (statusCode != 0) {
                        sh "exit 1"
                    } else {
                        sh 'curl -I -s -o output.txt http://localhost:8000/OurApp/'
                    }
                }
            }
        }
    }
}