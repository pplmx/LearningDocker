# Gerrit

## prerequisite

```shell
sudo install -d /opt/gerrit; cd /opt/gerrit; sudo install -d etc git db index cache ldap/var ldap/etc

# The content is from the file of the same name in the current directory
sudo touch gerrit.config secure.config
```

## installation

[Reference from Github Repo](https://github.com/GerritCodeReview/docker-gerrit)

### STEP-1: Run Gerrit docker init setup from docker

**Uncomment** the `command: init` option in `docker-compose.yaml` and run Gerrit with docker-compose in foreground.

```shell
docker compose up gerrit
```

Wait until you see in the output the message `Initialized /var/gerrit` and then the container will exit.

### STEP-2: Start Gerrit in daemon mode

**Comment out** the `command: init` option in docker-compose.yaml and start all the docker-compose nodes:

```shell
docker compose up -d
```

## Registering users in OpenLDAP with PhpLdapAdmin

### Define the Gerrit administrator in OpenLDAP

Login to PhpLdapAdmin on [https://localhost:6443](https://localhost:6443) using `cn=admin,dc=example,dc=org` as **username** and `secret` as **password**,
and then create a new child node of type "`Courier Mail Account`" for the Gerrit Administrator

Example:
- Given Name: Gerrit
- Last Name: Admin
- Common Name: Gerrit Admin
- User ID: gerritadmin
- Email: gerritadmin@localdomain
- Password: secret

### Login to Gerrit as Administrator

Login to Gerrit on [http://localhost](http://localhost) using the new Gerrit Admin credentials created on LDAP.

Example:

- Login: `gerritadmin`
- Password: `secret`

## Create a Repo and import an existed git repo to gerrit
