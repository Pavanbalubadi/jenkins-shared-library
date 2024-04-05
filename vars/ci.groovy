//stage('code checkout') {}
//stage('compile/download dependencies') {}
//stage('test cases') {}
//stage('integration test') {}
//stage('Build') {}
//stage('Release') {}
def call() {
    node('workstation') {
        sh 'env'
        stage('code checkout') {}
        stage('compile/download dependencies') {}

        if(env.BRANCH_NAME == "manin"){
            stage('Build') {}
        }else if (env.BRANCH_NAME ==~ "PR.*"){
            stage('integration test') {}
        }else if (env.TAG_NAME ==~ ".*"){
            stage('Build') {}
            stage('Release') {}
        }else {
            stage('test cases') {}
        }
    }

}