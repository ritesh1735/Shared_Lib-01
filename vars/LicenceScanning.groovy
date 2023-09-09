// installScancodeAndPerform.groovy
def call() {
    stage('Install scancode and perform') {
        steps {
            sh 'sudo pip install scancode-toolkit'
            sh 'scancode . --json reportfile.json'
            sh 'echo $PATH'
            sh 'which scancode'
        }
    }
}
