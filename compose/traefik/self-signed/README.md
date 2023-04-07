# Using Self-signed Certificate

## Create a certificate for `*.m.local`

```shell
# create a dir
install -d certs
openssl req -new -x509 -nodes -newkey rsa:4096 -days 365 \
    -subj "/C=CN/ST=Shanghai/L=Shanghai/CN=*.m.local" \
    -keyout certs/key.pem \
    -out certs/cert.pem

# traefik cannot recognize files with key and crt suffixes
openssl req -new -x509 -nodes -newkey rsa:4096 -days 365 \
    -subj "/C=CN/ST=Shanghai/L=Shanghai/CN=*.m.local" \
    -keyout certs/domain.key \
    -out certs/domain.crt
```
