def call() {
    node('workstation') {
        stage('sample') {
            echo 'nsample'
        }
    }
}