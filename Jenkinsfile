pipeline {
  agent any
  stages {
    stage('test') {
      steps {
          
          script{
              
              docker.image('maven:3.6.3-jdk-14').inside('-v /home/hsoo/.m2:/root/.m2') {
                  sh 'ls'
                  sh 'pwd'
                sh 'mvn compile test'
              }
          }
      }
    }

  }
}
