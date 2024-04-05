def call() {
    node('workstation') {
        sh 'env'


        If(BRANCH_NAME = "manin"){
            stage('code checkout') {}
            stage('compile/download dependencies') {}
            stage('Build') {}
        }

        stage('test cases') {}
        stage('integration test') {}
        stage('Build') {}
        stage('Release') {}

    }

}