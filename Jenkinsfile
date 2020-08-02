pipeline {
  agent any
  stages {
    stage('test') {
      steps {
          
          script{
              
              docker.image('maven:3.6.3-jdk-14').inside('-v /home/hsoo/.m2:/jenkins/.m2') {
                  sh 'ls'
                  sh 'pwd'
                sh 'mvn compile test'
              }
          }
          jacoco( 
              execPattern: 'target/*.exec',
              classPattern: 'target/classes',
              sourcePattern: 'src/main/java',
              exclusionPattern: 'src/test*'
          )
      }
    }

  }
}
