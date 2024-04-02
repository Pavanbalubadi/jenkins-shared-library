def call() {
    node('workstation') {
        stage('code') {}
        stage('compile/download dependencies') {}
        stage('test cases') {}
        stage('integration test') {}
        stage('Build') {}
        stage('Release') {}

    }

}