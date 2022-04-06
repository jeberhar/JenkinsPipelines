def call(Map pipelineParams) {
  pipeline {
    agent any
    options {
      durabilityHint 'PERFORMANCE_OPTIMIZED'
    }
    stages {
      stage('hello') {
        steps {
          helloWorld(name: "${pipelineParams.name}", dayOfWeek: "${pipelineParams.dayOfWeek}")
        }
      }
    }
  }
}
