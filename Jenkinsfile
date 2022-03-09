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

        stage('GIT env vars') {
          steps {
            sh 'env | grep GIT_'
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

        stage('Unstash') {
          steps {
            unstash 'Stash'
          }
        }

      }
    }

    stage('Input') {
      steps {
        input(message: 'Did you enjoy this build?', submitter: 'admin', ok: 'Hell yes!')
      }
    }

    stage('Deploy to Staging') {
      when {
        branch 'master'
      }
      steps {
        sh '''echo "Deploying to staging"
sleep 3
echo "Deploy to staging is complete"'''
      }
    }

  }
  environment {
    BUZZ_NAME = 'Worker Bee'
  }
}
