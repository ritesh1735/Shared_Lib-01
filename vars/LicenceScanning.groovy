package org.<your-shared-library-name>

class LicenseScanner {
    def run() {
        script {
            def scancodeInstalled = sh(script: 'command -v scancode', returnStatus: true) == 0
            if (!scancodeInstalled) {
                sh 'sudo pip install scancode-toolkit'
            }

            sh 'scancode . --json reportfile.json'
            sh 'echo $PATH'
            sh 'which scancode'
        }
    }
}

// def call() {
//     def scancodeInstalled = fileExists('$(which scancode)')

//     if (!scancodeInstalled) {
//         sh 'sudo pip install scancode-toolkit'
//     }

//     sh 'scancode . --json reportfile.json'
//     sh 'echo $PATH'
//     sh 'which scancode'
// }

// // // installScancodeAndPerform.groovy
// // def call() {
// //             sh 'sudo pip install scancode-toolkit'
// //             sh 'scancode . --json reportfile.json'
// //             sh 'echo $PATH'
// //             sh 'which scancode'
// //         }
    

