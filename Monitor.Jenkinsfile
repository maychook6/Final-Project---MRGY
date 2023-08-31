pipeline {
    agent any

    stages {
        stage('Monitor') {
            when {
                
            }
                steps {
                    script {
                        if (runShell('grep \'200\' output.txt')) {
                        sh "exit 1"
                    }

                    }
                    sh 'curl -I -s -o output.txt http://localhost:8000/OurApp/'
                }
            }
        }
    }
}