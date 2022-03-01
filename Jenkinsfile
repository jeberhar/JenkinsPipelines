pipeline {
  agent any
  stages {
    stage('Buzz Build') {
      steps {
        sh '''
echo "Building software....."
sleep 5






echo "Built the software!"'''
        archiveArtifacts(artifacts: 'pipeline.log', fingerprint: true, allowEmptyArchive: true)
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
}