def call(Map pipelineParams) {
  pipeline {
    agent any
    options {
      durabilityHint 'PERFORMANCE_OPTIMIZED'
      preserveStashes(buildCount: 5)
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
