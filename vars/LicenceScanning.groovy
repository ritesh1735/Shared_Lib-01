// installScancodeAndPerform.groovy
def call() {
            sh 'sudo pip install scancode-toolkit'
            sh 'scancode . --json reportfile.json'
            sh 'echo $PATH'
            sh 'which scancode'
        }
    

