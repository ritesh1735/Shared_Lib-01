# Shared_Lib-01
// Jenkinsfile

@Library('your-shared-library-name') // Replace 'your-shared-library-name' with the actual name of your shared library.
import greeting

pipeline {
    agent any

    stages {
        stage('Greeting') {
            steps {
                script {
                    def personName = "Alice"
                    
                    def greetingMessage = greeting.greet(personName)
                    def farewellMessage = greeting.farewell(personName)
                    
                    echo "Greeting: $greetingMessage"
                    echo "Farewell: $farewellMessage"
                }
            }
        }
    }
}
