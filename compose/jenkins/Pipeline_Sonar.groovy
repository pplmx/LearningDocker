pipeline {
    agent any
    environment {
        // this Node18 is from NodeJS plugin creation
        NODEJS_HOME = tool 'Node18'
        PATH = "${NODEJS_HOME}/bin:${env.PATH}"
        // for windows
        // PATH = "${NODEJS_HOME}/bin;${env.PATH}"
    }
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
                    // Just check if the node is ready or not
                    // If you don't check nodejs project, you can remove
                    // - sh "npm config ls"
                    // - the above nodejs environment config
                    sh "npm config ls"
                    def scannerHome = tool 'SonarScanner';
                    withSonarQubeEnv() {
                       sh "${scannerHome}/bin/sonar-scanner"
                    }
                }
            }
        }
    }
}
