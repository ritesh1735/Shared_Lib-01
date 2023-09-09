// cleanWorkspace.groovy
def call() {
    stage('Clean Workspace') {
        steps {
            cleanWs()
        }
    }
}
