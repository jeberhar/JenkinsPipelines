pipeline {
  agent any
  stages {
    stage('Buzz Build') {
      parallel {
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

        stage('Stash') {
          steps {
            stash(name: 'Stash', allowEmpty: true, includes: 'pipeline.log')
          }
        }

      }
    }

    stage('Buzz Test') {
      parallel {
        stage('Buzz Test') {
          steps {
            sh '''echo "Testing software....."
sleep 5
echo "Tested the software!"'''
          }
        }

        stage('Testing B') {
          steps {
            sh '''sleep 2
echo done'''
          }
        }

      }
    }

  }
  environment {
    BUZZ_NAME = 'Worker Bee'
  }
}