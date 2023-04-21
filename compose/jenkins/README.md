# Jenkins

1. deploy the traefik first
2. deploy the jenkins
3. access http://jenkins.x.internal

```shell
# View the generated administrator password to log in the first time.
docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword
```

## Configure NodeJS for a Sonar Scanner NodeJS project

1. install [NodeJS plugin](https://plugins.jenkins.io/nodejs/)
2. Dashboard > Manage Jenkins > Tools > NodeJS
    - Extract *.zip/*.tar.gz
    - Install from nodejs.org
    - Install from nodejs.org mirror
3. select `Install from nodejs.org` and named name with **Node18**(This will be used in `tool 'Node18'`)
4. Actually, the nodejs always doesn't be installed.
5. Workaround:
    - Create a FreeStyle project to install it
    - choose the `Node18` in `Build Environment`
    - `Build Now`
