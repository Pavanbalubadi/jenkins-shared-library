
//stage('code checkout') {}
//stage('compile/download dependencies') {}
//stage('test cases') {}
//stage('integration test') {}
//stage('Build') {}
//stage('Release') {}
def call() {
    node('workstation') {
        ansiColor('xterm') {}
        sh 'env'
        sh "find . | sed -e '1d' |xargs rm -rf"

        if (env.TAG_NAME ==~ ".*") {
            env.branch_name = "refs/tags/${env.TAG_NAME}"
        } else {
            if (env.BRANCH_NAME ==~ "PR-.*") {
                env.branch_name = "${env.CHANGE_BRANCH}"
            } else {
                env.branch_name = "${env.BRANCH_NAME}"
            }


            stage('code checkout') {
                //git branch: 'main', url: 'https://github.com/Pavanbalubadi/expense-backend.git'
                checkout scmGit(
                        branches: [[name: "${branch_name}"]],
                        userRemoteConfigs: [[url: "https://github.com/Pavanbalubadi/expense-backend.git"]]
                )
            }


            stage('compile/download dependencies') {}

            if (env.BRANCH_NAME == "main") {
                stage('Build') {}
            } else if (env.BRANCH_NAME == "PR.*") {
                stage('integration test') {}
            } else if (env.TAG_NAME ==~ ".*") {
                stage('Build') {}
                stage('Release') {}
            } else {
                stage('test cases') {}
            }


        }
    }
}
