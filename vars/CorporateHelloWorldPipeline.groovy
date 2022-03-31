def call(Map pipelineParams) {
    pipeline {
        agent any
        stages {
            stage('hello') {
                steps {
                    CorporateHelloWorldPipeline(name: "${pipelineParams.name}", dayOfWeek: "${pipelineParams.dayOfWeek}")
                }
            }
        }
    }
}
