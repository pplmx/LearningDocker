# AdGuard

Port mappings you might need:

`-p 53:53/tcp -p 53:53/udp`: plain DNS.

`-p 67:67/udp -p 68:68/tcp -p 68:68/udp`: for DHCP server.

> If you want to use DHCP server, you need to add `network_mode: host` to the service,
> and remove the entire "ports" section.

`-p 80:80/tcp -p 443:443/tcp -p 443:443/udp -p 3000:3000/tcp`: for Admin panel and DNS-over-HTTPS server.

`-p 853:853/tcp`: DNS-over-TLS server.

`-p 784:784/udp -p 853:853/udp -p 8853:8853/udp`: for DNS-over-QUIC server.

`-p 5443:5443/tcp -p 5443:5443/udp`: for DNSCrypt server.

## Error starting userland proxy: listen tcp4 0.0.0.0:53: bind: address already in use

```bash
# list all listening ports
sudo lsof -nPi

# list all listening TCP ports
sudo lsof -nPi TCP

# list all listening UDP ports
sudo lsof -nPi UDP

# list TCP port 53
sudo lsof -nPi TCP:53
```

By `sudo lsof -nPi TCP:53`, you will see something like this:

```bash
COMMAND   PID            USER   FD   TYPE DEVICE SIZE/OFF NODE NAME
systemd-r 141 systemd-resolve   14u  IPv4  31766      0t0  TCP 127.0.0.53:53 (LISTEN)
```

This means that `systemd-resolve` is listening on port 53.

To stop it, uncomment `DNSStubListener` and set `no` in `/etc/systemd/resolved.conf`:

```bash
# ...

[Resolve]
# ...
DNSStubListener=no
# ...

```

Then restart `systemd-resolved`:

```bash
sudo systemctl restart systemd-resolved
```

## FYI

[Referenced](https://www.smarthomebeginner.com/adguard-home-docker-compose-guide)
