pipeline {
    agent any
    stages {
        stage('Clean Workspace') {
            steps {
                deleteDir()
            }
        }
        stage('Checkout Gerrit Latest PatchSet') {
            steps {
                echo "Gerrit: ${GERRIT_HOST}:${GERRIT_PORT}"
                echo "Project: ${GERRIT_PROJECT}\nBranch: ${GERRIT_BRANCH}\nRefSpec: ${GERRIT_REFSPEC}"
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: "${GERRIT_BRANCH}"]],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [[$class: 'CleanBeforeCheckout']],
                    submoduleCfg: [],
                    userRemoteConfigs: [[
                        refspec: "${GERRIT_REFSPEC}",
                        url: 'http://${GERRIT_HOST}/${GERRIT_PROJECT}'
                    ]]
                ])
            }
        }
        stage('SonarQube Analysis') {
            when {
                expression { return fileExists('sonar-project.properties') }
            }
            steps {
                script {
                    def scannerHome = tool 'SonarScanner';
                    withSonarQubeEnv() {
                       sh "${scannerHome}/bin/sonar-scanner"
                    }
                }
            }
        }
    }
}
