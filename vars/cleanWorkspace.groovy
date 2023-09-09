// Shared_Lib-01/vars/Cleanworkspace.groovy

def call() {
    stage('CleanWorkspace') {
        steps {
            cleanWs()
            // Add other steps specific to your 'CleanWorkspace' stage
        }
    }
}


// // cleanWorkspace.groovy
// def call() {
//     cleanWs()
// }

