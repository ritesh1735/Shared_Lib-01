// Shared_Lib-01/vars/myStages.groovy

def Cleanworkspace() {
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

