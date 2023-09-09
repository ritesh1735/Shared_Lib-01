// CredentialScaning.groovy

def call() {
    def gitleaksInstalled = fileExists('/usr/local/bin/gitleaks')

    if (!gitleaksInstalled) {
        sh 'wget https://github.com/zricethezav/gitleaks/releases/download/v7.0.2/gitleaks-linux-amd64 -O gitleaks'
        sh 'chmod +x gitleaks'
        sh 'sudo mv gitleaks /usr/local/bin/'
    }

    sh 'gitleaks --version' // Check Gitleaks version to verify installation

    if (!gitleaksInstalled) {
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
    }

    sh 'gitleaks detect -p . --files-at-commit=latest .'
}

// def call() {
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
//     sh 'gitleaks detect -p . --files-at-commit=latest .'
// }
