# SonarQube

## start a sonar server

```shell
docker compose up -d
```

## start a sonar scanner

1. create a `sonar-project.properties` at the root dir of your repo, like this:
```properties
# 172.17.0.1 is a docker0 ip, due to the sonar server starts with the docker.
sonar.host.url=http://172.17.0.1:9000
sonar.login=849d0a95e7572891592272b917d82a55586cd785

sonar.sonar.sourceEncoding=UTF-8

sonar.projectKey=individual.mystic
sonar.projectName=Learning Go in Action

sonar.sources=.
sonar.exclusions=**/*_test.go,**/vendor/**

sonar.tests=.
sonar.test.inclusions=**/*_test.go
sonar.test.exclusions=**/vendor/**
```

2. start a scanner
```shell
docker run \
    --rm \
    -v "${YOUR_REPO}:/usr/src" \
    sonarsource/sonar-scanner-cli
```

> If you don't want to create `sonar-project.properties`, you can follow this:
```shell
docker run \
    --rm \
    -e SONAR_HOST_URL="http://${SONARQUBE_URL}" \
    -e SONAR_LOGIN="849d0a95e7572891592272b917d82a55586cd785" \
    -v "${YOUR_REPO}:/usr/src" \
    sonarsource/sonar-scanner-cli \
    -Dsonar.projectKey=individual.mystic \
    -Dsonar.sonar.projectName="Learning Go in Action" \
    -Dsonar.sonar.projectVersion=1.0 \
    -Dsonar.sonar.sources="/usr/src" \
    -Dsonar.exclusions="**/*_test.go,**/vendor/**" \
    -Dsonar.sonar.sourceEncoding=UTF-8
```
