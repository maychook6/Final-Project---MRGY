pipeline {
    agent any

    stages {
        stage('Set Execution') {
            when {
                anyOf {
                    changeset "OurApp/index.jsp"
                }
            }
            stages {
               stage('Deploy') {
                    steps {
                        sh 'cp -R -f OurApp ~/Downloads/apache-tomcat-8.5.92/webapps'
                    }
                }
                stage('Selenium') {
                    steps {
                        sh 'python3 pytest test_finelProjectTest.py'
                    }
                }
                stage('Load Test') {
                    steps {
                        sh '''
                            cp -f simulations/LoadSimulation.java ~/Downloads/gatling-charts-highcharts-bundle-3.9.5/user-files/simulations
                            cd ~/Downloads/gatling-charts-highcharts-bundle-3.9.5/bin
                            ./gatling.sh -rm local -s LoadSimulation
                        '''
                    }
                }
                stage('Stress Test') {
                    steps {
                        sh '''
                            # copy stress simulation file from repo 
                            cp -f simulations/StressSimulation.java ~/Downloads/gatling-charts-highcharts-bundle-3.9.5/user-files/simulations
                            cd ~/Downloads/gatling-charts-highcharts-bundle-3.9.5/bin
                            ./gatling.sh -rm local -s StressSimulation
                            '''
                        
                    }
                }
            }
        }
    }
}