# SonarQube

1. deploy the traefik first
2. deploy the sonar
3. access http://sonar.m.local

## Docker Host Requirements

> Because SonarQube uses an embedded Elasticsearch,
> make sure that your Docker host configuration complies with the Elasticsearch production mode requirements
> and File Descriptors configuration.

> For example, on Linux, you can set the recommended values for the current session
> by running the following commands as root on the host:

```shell
sysctl -w vm.max_map_count=524288
sysctl -w fs.file-max=131072
ulimit -n 131072
ulimit -u 8192
```

## Start a SonarQube Server

```shell
# after configuration, restart the docker daemon
sudo systemctl restart docker

docker compose up -d
# docker compose build && docker compose up -d
```

## Start a Sonar Scanner

- create a `sonar-project.properties` at the root dir of your repo, like this:

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

- start a scanner

```shell
docker run \
    --rm \
    -v "${YOUR_REPO}:/usr/src" \
    sonarsource/sonar-scanner-cli
```

> If you don't want to create `sonar-project.properties`, you can follow this:

```shell
SONARQUBE_URL="http://127.0.0.1:9000/"
SONARQUBE_TOKEN=""
YOUR_REPO=""
docker run \
    --rm \
    -e SONAR_HOST_URL="${SONARQUBE_URL}" \
    -e SONAR_LOGIN="${SONARQUBE_TOKEN}" \
    -v "${YOUR_REPO}:/usr/src" \
    sonarsource/sonar-scanner-cli \
    -Dsonar.projectKey=individual.mystic \
    -Dsonar.sonar.projectName="Learning Go in Action" \
    -Dsonar.sonar.projectVersion=1.0 \
    -Dsonar.sonar.sources="/usr/src" \
    -Dsonar.exclusions="**/*_test.go,**/vendor/**" \
    -Dsonar.sonar.sourceEncoding=UTF-8
```

> Or using the command line directly:

```shell
sonar-scanner \
    -Dsonar.projectKey=Aurora \
    -Dsonar.sources=. \
    -Dsonar.host.url=http://192.168.91.37:9000 \
    -Dsonar.login=sqp_d2a893edf42a9e5ccb72cdcd77a2f1b391f4f525
```
