pipeline {
  agent any
  stages {
    stage('Buzz Build') {
      steps {
        sh '''


echo "I am a ${BUZZ_NAME}"
echo "Building software....."
sleep 5






echo "Built the software!"'''
        archiveArtifacts(artifacts: '*.*', fingerprint: true, allowEmptyArchive: true)
      }
    }

    stage('Buzz Test') {
      steps {
        sh '''echo "Testing software....."
sleep 5
echo "Tested the software!"'''
      }
    }

  }
  environment {
    BUZZ_NAME = 'Worker Bee'
  }
}