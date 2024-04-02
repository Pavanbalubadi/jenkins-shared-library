def call() {
    pipeline {
        agent { node { label 'workstation' } }
        options {
            ansiColor('xterm')
        }
        stages {
            stage('compile/Download') {
                steps {
                    echo 'compile/Download'
                }
            }
            stage('test cases') {
                steps {
                    echo 'test cases'
                }
            }
            stage('integration test') {
                steps {
                    echo 'integration test'
                }
            }
            stage('Build') {
                steps {
                    echo 'Build'
                }
            }
            stage('Release') {
                steps {
                    echo 'Release'
                }
            }


        }
    }

}