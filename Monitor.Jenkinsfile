pipeline {
    agent any

    stages {
        stage('Monitor') {
            steps {
                script {
                    def statusCode = sh(script: 'grep "200" output.txt', returnStdout: true)
                    if (statusCode != '200') {
                        sh "exit 1"
                    } else {
                        sh 'curl -I -s -o output.txt http://localhost:8000/OurApp/'
                    }
                }
            }
        }
    }
}