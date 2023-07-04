pipeline {
    agent any
    stages {
        stage('Conventional Analysis') {
            steps {
                script {
                    echo "GERRIT_CHANGE_SUBJECT: ${GERRIT_CHANGE_SUBJECT}"
                    def changeSubj = "$GERRIT_CHANGE_SUBJECT".trim()
                    def match = (changeSubj =~ /^(build|chore|ci|docs|feat|fix|perf|refactor|revert|style|test)(\([A-Za-z]+\))?:\s.+$/)
                    if (!match) {
                        echo "Non-Conventional Commit: \n${changeSubj}"
                        error("Commit message does not follow conventional commit format")
                    } else {
                        echo "Conventional Commit: \n${changeSubj}"
                    }
                }
            }
        }
        stage('Change-Id Required') {
            steps {
                script {
                    echo "GERRIT_CHANGE_COMMIT_MESSAGE: ${GERRIT_CHANGE_COMMIT_MESSAGE}"
                    def encodedString = "$GERRIT_CHANGE_COMMIT_MESSAGE"
                    def decodedBytes = java.util.Base64.decoder.decode(encodedString)
                    def commitMessage = new String(decodedBytes, "UTF-8")
                    echo "$commitMessage"
                    // trim for each line and filter out the empty line
                    def lines = commitMessage.split('\n').collect { it.trim() }.findAll { it }
                    echo "$lines"
                    def changeIdCount = lines.count { it.startsWith('Change-Id: ') }
                    if (changeIdCount < 1) {
                        error("Change-Id is required.")
                    }
                    if (changeIdCount > 1) {
                        // Change-Id: occurrences are over than 1
                        error("Change-Id occurrences are over than 1. Please remove the redundant.")
                    }
                }
            }
        }
        stage('Issue-Id Required') {
            steps {
                script {
                    def encodedString = "$GERRIT_CHANGE_COMMIT_MESSAGE"
                    def decodedBytes = java.util.Base64.decoder.decode(encodedString)
                    def commitMessage = new String(decodedBytes, "UTF-8")
                    // trim for each line and filter out the empty line
                    def lines = commitMessage.split('\n').collect { it.trim() }.findAll { it }
                    def changeIdCount = lines.count { it.startsWith('issue: #') }
                    if (changeIdCount < 1) {
                        error("Issue-Id is required. \nLike as: \nissue: #I6U9YE")
                    }
                }
            }
        }
    }
}
