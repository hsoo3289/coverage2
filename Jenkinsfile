pipeline {
  agent any
  stages {
    stage('') {
      steps {
        sh 'docker run -v$(pwd):/home -w=/home maven:3.6.3-jdk-14 mvn compile test'
      }
    }

  }
}