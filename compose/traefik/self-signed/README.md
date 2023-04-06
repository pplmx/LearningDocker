# Using Self-signed Certificate

## Create a certificate for `*.m.local`

```shell
# create a dir
install -d certs
openssl req -new -x509 -nodes -newkey rsa:4096 \
    -subj "/C=CN/ST=Shanghai/L=Shanghai/CN=*.m.local" \
    -keyout certs/domain.key \
    -out certs/domain.crt
```
