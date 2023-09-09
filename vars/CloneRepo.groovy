// checkout.groovy
def call(String branch, String repoUrl) {
    git branch: branch, url: repoUrl
}

// // checkout.groovy
// def call(String branch, String repoUrl) {
//     stage('Checkout') {
//         steps {
//             git branch: branch, url: repoUrl
//         }
//     }
// }
