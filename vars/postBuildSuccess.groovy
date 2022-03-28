def call(Map config = [:]) {
    archiveArtifacts allowEmptyArchive: true, 'target/*.jar'
    stash(name: "${config.stashName}", includes: 'target/**')
}
