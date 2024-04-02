def call() {
    node('workstation') {
        options {
            ansiColor('xterm')
        }
        stage('code') {}
        stage('compile') {}

    }
}