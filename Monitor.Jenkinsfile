pipeline {
    agent any

    stages {
        stage('Monitor') {
            steps {
                if (statusCode != '200') {
                    sh "exit 1"
                } else {
                        sh 'curl -I -s -o output.txt http://localhost:8000/OurApp/'
                }
            }
        }
    }
}
 
 def statusCode() {
    def shell = 'grep "200" output.txt'
    def process = shell.execute()
    process.waitFor()
    return process.text
}