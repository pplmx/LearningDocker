# append config to configuration.yaml

```yaml
# === Added by myself ===
bluetooth:
http:
    use_x_forwarded_for: true
    trusted_proxies:
        - 172.16.238.0/24
        - 127.0.0.1
        - ::1
```
