def call() {
    node('workstation') {
        sh 'env'
        stage('code') {}
        stage('compile/download dependencies') {}
        if(env.BRANCH_NAME=main){
            stage('Build') {}
        }else if(env.BRANCH_NAME ==~ "PR.*"){
            stage('integration test') {}
        }
        (env.TAG_NAME ==~ ".*"){
            stage('Build') {}
            stage('Release') {}
        }






    }

}