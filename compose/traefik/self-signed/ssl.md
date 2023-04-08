# OpenSSL

```shell
# generate rootCA
openssl req -x509 -new -nodes -days 3650\
    -config ssl.cnf \
    -keyout certs/rootCA.key.pem \
    -out certs/rootCA.crt.pem

# generate server certificate
openssl genrsa -out certs/server.key.pem 4096
openssl req -new -config ssl.cnf -key certs/server.key.pem -out certs/server.csr.pem
openssl x509 -req -sha256 -CAcreateserial \
    -days 365 \
    -in certs/server.csr.pem \
    -CA certs/rootCA.crt.pem \
    -CAkey certs/rootCA.key.pem \
    -out certs/server.crt.pem
```
