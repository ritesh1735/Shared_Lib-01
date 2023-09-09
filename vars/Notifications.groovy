// JenkinsNotifications.groovy

ackage org.mycompany

def static sendSuccessNotification() {
    slackSend(
        channel: 'jenkins_report',
        color: '#439FE0',
        message: "JOB_NAME: ${env.JOB_NAME} BUILD_ID: ${env.BUILD_ID} WORKSPACE: ${env.WORKSPACE} Successful",
        teamDomain: 'opstree',
        tokenCredentialId: 'f283508e-362f-444d-94d5-15fb0b561a86',
        username: 'Ritesh Kumar'
    )
    emailext(
        body: 'Build Success',
        recipientProviders: [developers()],
        replyTo: 'riteshkuma19325@gmail.com',
        subject: 'attendance_api_pipeline',
        to: 'riteshkumar19325@gmail.com'
    )
}

def static sendFailureNotification() {
    slackSend(
        channel: 'jenkins_report',
        color: '#439FE0',
        message: "JOB_NAME: ${env.JOB_NAME} BUILD_ID: ${env.BUILD_ID} WORKSPACE: ${env.WORKSPACE} Unsuccessful",
        teamDomain: 'opstree',
        tokenCredentialId: 'f283508e-362f-444d-94d5-15fb0b561a86',
        username: 'Ritesh Kumar'
    )
    emailext(
        body: 'Build failure',
        recipientProviders: [developers()],
        replyTo: 'riteshkuma19325@gmail.com',
        subject: 'attendance_api_pipeline',
        to: 'riteshkumar19325@gmail.com'
    )
}
