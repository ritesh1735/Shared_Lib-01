// Shared_Lib-01/vars/myStages.groovy

def myGitHubStage() {
    stage('CleanWorkspace') {
        steps {
            cleanWs()
            // Add other steps
        }
    }
}

// // cleanWorkspace.groovy
// def call() {
//     cleanWs()
// }

