def call(Map pipelineParams) {
  pipeline {
      agent any
      stages {
          stage("build and deploy on Windows and Linux") {
              parallel {
                  stage("windows") {
                      stages {
                          stage("build") {
                              steps {
                                  sh "echo WindowsBuild"
                              }
                          }
                          stage("deploy") {
                              //when { branch 'feature' }
                              steps {
                                  helloWorld(name: "${pipelineParams.name}", dayOfWeek: "${pipelineParams.dayOfWeek}")
                              }
                          }
                      }
                  }
                  stage("linux") {
                      stages {
                          stage("build") {
                              steps {
                                  sh "echo LinuxBuild"
                              }
                          }
                          stage("deploy") {
                               //when { branch 'feature' }
                               steps {
                                  helloWorld(name: "${pipelineParams.name}", dayOfWeek: "${pipelineParams.dayOfWeek}")
                              }
                          }
                      }
                  }
              }
          }
      }
  }
}
