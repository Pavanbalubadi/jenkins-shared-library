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


        if(BRANCH_NAME = "manin"){
            stage('Build') {}
        }else if (BRANCH_NAME ==~ "PR.*"){
            stage('integration test') {}
        }else if (TAG_NAME ==~ ".*"){
            stage('Build') {}
            stage('Release') {}
        }else {
            stage('test cases') {}
        }
    }

}