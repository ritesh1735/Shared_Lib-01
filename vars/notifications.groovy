// my-shared-library/vars/notification.groovy

def call(Map config) {
    def channel = config.channel
    def color = config.color
    def message = config.message
    def teamDomain = config.teamDomain
    def tokenCredentialId = config.tokenCredentialId
    def username = config.username

    try {
        if (currentBuild.resultIsBetterOrEqualTo('SUCCESS')) {
            echo "${env.JOB_NAME}"
            slackSend channel: channel, color: color, message: message, teamDomain: teamDomain, tokenCredentialId: tokenCredentialId, username: username
        } else {
            echo "${env.JOB_NAME}"
            slackSend channel: channel, color: color, message: "JOB_NAME: ${env.JOB_NAME} BUILD_ID: ${env.BUILD_ID} WORKSPACE: ${env.WORKSPACE} Unsuccessful", teamDomain: teamDomain, tokenCredentialId: tokenCredentialId, username: username
        }
    } catch (Exception e) {
        currentBuild.result = 'FAILURE'
        throw e
    }
}
