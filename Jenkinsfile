pipeline {
    agent any

    stages {
        stage('Set Execution') {
            when {
                changeset "OurApp/index.jsp"
            }
            stages {
               stage('Deploy') {
                    steps {
                        sh 'cp -R -f OurApp ~/Downloads/apache-tomcat-8.5.92/webapps'
                    }
                }
                stage('Selenium') {
                    steps {
                        //Run converted Selenium IDE recording to python pytest
                        //Selenium IDE -> Record test -> Click Export -> Choose python -> Run converted recording file with pytest
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
                        '''
                        dir('~/Downloads/gatling-charts-highcharts-bundle-3.9.5/bin') {
                            sh './gatling.sh -rm local -s StressSimulation'
                        }
                    }
                }
            }
        }
    }
}