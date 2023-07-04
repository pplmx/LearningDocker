pipeline {
    agent any
    tools {
        nodejs 'Node18'
    }
    stages {
        stage('Clean Workspace') {
            steps {
                deleteDir()
                sh 'git config --global http.sslVerify false'
            }
        }
        stage('SCM') {
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
                        url: 'https://${GERRIT_HOST}/${GERRIT_PROJECT}'
                    ]]
                ])
                script {
                    if (env.GERRIT_CHANGE_NUMBER && env.GERRIT_PATCHSET_NUMBER) {
                        def changeBranch = "change-${GERRIT_CHANGE_NUMBER}-${GERRIT_PATCHSET_NUMBER}"
                        sh "git fetch https://${GERRIT_HOST}/${GERRIT_PROJECT} ${GERRIT_REFSPEC}"
                        sh "git checkout -b ${changeBranch} FETCH_HEAD"
                    }
                }
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
