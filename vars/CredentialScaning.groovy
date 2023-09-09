// CredentialScaning.groovy

def call() {
    sh 'wget https://github.com/zricethezav/gitleaks/releases/download/v7.0.2/gitleaks-linux-amd64 -O gitleaks'
    sh 'chmod +x gitleaks'
    sh 'sudo mv gitleaks /usr/local/bin/'
    sh 'gitleaks --report-format=toml > .gitleaks.toml'
    sh '''
        echo '[[rules]]
        pattern = "api_key"
        exclude = ["*.md"]
        severity = "high"

        [[rules]]
        pattern = "password"
        commit = true' > .gitleaks.toml
    '''
    sh 'cat .gitleaks.toml'
    sh 'gitleaks detect -p . --files-at-commit=latest .'
}

// // GitleaksScan.groovy

// def generateAndEditGitleaksConfig() {
//     sh 'wget https://github.com/zricethezav/gitleaks/releases/download/v7.0.2/gitleaks-linux-amd64 -O gitleaks'
//     sh 'chmod +x gitleaks'
//     sh 'sudo mv gitleaks /usr/local/bin/'
//     sh 'gitleaks --report-format=toml > .gitleaks.toml'
//     sh '''
//         echo '[[rules]]
//         pattern = "api_key"
//         exclude = ["*.md"]
//         severity = "high"

//         [[rules]]
//         pattern = "password"
//         commit = true' > .gitleaks.toml
//     '''
//     sh 'cat .gitleaks.toml'
// }

// def performGitleaksScan() {
//     sh '''pwd
//     ls -la
//     '''
//     sh 'gitleaks detect -p . --files-at-commit=latest .'
// }

// // def call() {
// //     stage('Generate, Edit, and Run Gitleaks Scan') {
// //         steps {
// //             script {
// //                 // Generate and edit Gitleaks configuration
// //                 sh 'wget https://github.com/zricethezav/gitleaks/releases/download/v7.0.2/gitleaks-linux-amd64 -O gitleaks'
// //                 sh 'chmod +x gitleaks'
// //                 sh 'sudo mv gitleaks /usr/local/bin/'
// //                 sh 'gitleaks --report-format=toml > .gitleaks.toml'
// //                 sh '''
// //                     echo '[[rules]]
// //                     pattern = "api_key"
// //                     exclude = ["*.md"]
// //                     severity = "high"

// //                     [[rules]]
// //                     pattern = "password"
// //                     commit = true' > .gitleaks.toml
// //                 '''
// //                 sh 'cat .gitleaks.toml'
                
// //                 // Perform the Gitleaks scan
// //                 sh '''pwd
// //                 ls -la
// //                 '''
// //                 sh 'gitleaks detect -p . --files-at-commit=latest .'
// //             }
// //         }
// //     }
// // }
// // // // gitleaksPipeline.groovy
// // // def call() {
// // //     stage('Generate, Edit, and Run Gitleaks Scan') {
// // //         steps {
// // //             script {
// // //                 // Generate and edit Gitleaks configuration
// // //                 sh 'wget https://github.com/zricethezav/gitleaks/releases/download/v7.0.2/gitleaks-linux-amd64 -O gitleaks'
// // //                 sh 'chmod +x gitleaks'
// // //                 sh 'sudo mv gitleaks /usr/local/bin/'
// // //                 sh 'gitleaks --report-format=toml > .gitleaks.toml'
// // //                 sh '''
// // //                     echo '[[rules]]
// // //                     pattern = "api_key"
// // //                     exclude = ["*.md"]
// // //                     severity = "high"

// // //                     [[rules]]
// // //                     pattern = "password"
// // //                     commit = true' > .gitleaks.toml
// // //                 '''
// // //                 sh 'cat .gitleaks.toml'
                
// // //                 // Perform the Gitleaks scan
// // //                 sh '''pwd
// // //                 ls -la
// // //                 '''
// // //                 sh 'gitleaks detect -p . --files-at-commit=latest .'
// // //             }
// // //         }
// // //     }
// // // }
