pipeline {
  agent any
  stages {
    stage('Buzz Build') {
      steps {
        sh 'sudo ./jenkins/build.sh'
      }
    }

    stage('Buzz Test') {
      steps {
        sh 'sudo ./jenkins/test-all.sh'
      }
    }

  }
}