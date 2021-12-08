# K8S

```shell
# install ingress-nginx by helm
helm upgrade --install ingress-nginx ingress-nginx \
  --repo https://kubernetes.github.io/ingress-nginx \
  --namespace ingress-nginx --create-namespace

# by minikube
minikube addons enable ingress
```
