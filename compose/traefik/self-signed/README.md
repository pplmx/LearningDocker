# Using Self-signed Certificate

## preparation

```shell
install -d certs
```

## Create with mkcert

`mkcert` installation is here: https://github.com/FiloSottile/mkcert

`mkcert` can solve the problem of browser distrust
If you want to solve this problem, then `mkcert` is the best choice.

```shell
# directly gen certs at the current dir
# mkcert example.com "*.example.com" example.test localhost 127.0.0.1 ::1

# specify the cert out
mkcert -key-file certs/key.pem -cert-file certs/cert.pem x.internal "*.x.internal"
mkcert -install
```


## Create with OpenSSL
> this issue is `browser distrust`
> If you're not particularly concerned about this issue
> and are more focused on other configurations of openssl,
> then using the openssl command would be a better choice.

```shell
# Option 1: use ssl.cnf
# When using -x509, default_days in config will be ignored, it is a bug
# using -days to workaround
openssl req -x509 -new -nodes -days 365\
    -config ssl.cnf \
    -keyout certs/key.pem \
    -out certs/cert.pem

# Option 2: use command line arguments
openssl req -new -x509 -nodes -newkey rsa:4096 -days 365 \
    -subj "/C=CN/ST=SH/L=Shanghai/CN=*.x.internal" \
    -keyout certs/key.pem \
    -out certs/cert.pem

# Option 3
# traefik cannot recognize files with key and crt suffixes
openssl req -new -x509 -nodes -newkey rsa:4096 -days 365 \
    -subj "/C=CN/ST=Shanghai/L=Shanghai/CN=*.x.internal" \
    -keyout certs/domain.key \
    -out certs/domain.crt
```
