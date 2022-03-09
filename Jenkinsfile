pipeline {
  agent any
  stages {
    stage('Buzz Build') {
      parallel {
        stage('Buzz Build') {
          steps {
            withCredentials(bindings: [string(credentialsId: 'plain', variable: 'ELASTIC_ACCESS_KEY')]) {
            // Environment Variable available in the remote shell
              sh 'env | grep ELASTIC_ACCESS_KEY'
              sh "echo $\{ELASTIC_ACCESS_KEY}"
            }
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

    stage('InputWhen Example') {
            input {
                message "Should we continue?"
                ok "Yes, we should."
                submitter "admin"
                parameters {
                    string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I greet?')
                }
            }
            when {
                equals expected: "admin", actual: "${PERSON}"
            }
            steps {
                echo "Hello, ${PERSON}, nice to meet you."
            }
    }
    
    stage('Deploy to Staging') {
      when {
        branch 'main'
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
