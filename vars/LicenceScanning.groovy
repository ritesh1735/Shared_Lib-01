def call() {
    def scancodeInstalled = fileExists('$(which scancode)')

    if (!scancodeInstalled) {
        sh 'sudo pip install scancode-toolkit'
    }

    sh 'scancode . --json reportfile.json'
    sh 'echo $PATH'
    sh 'which scancode'
}

    

