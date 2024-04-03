def call() {
    node('workstation') {
        sh 'env'
        stage('code') {}
        stage('compile/download dependencies') {}
        stage('test cases') {}
        stage('integration test') {}
        stage('Build') {}
        stage('Release') {}

    }

}