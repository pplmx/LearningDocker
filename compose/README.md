# Compose 服务索引

每个服务一个目录。使用前先复制根目录 `.env.example` 为 `.env` 并填好 `HOST_IP`
（部分服务通过 `host.docker.internal` 访问宿主机，IP 不再硬编码进仓库）。

## 网关 / 反向代理

| 目录 | 说明 |
| --- | --- |
| `traefik/http` | Traefik 入口，自备 `/certs` 证书（目录已 gitignore，需自行放入 `cert.pem` / `key.pem`），HTTP/3 开启 |
| `traefik/self-signed` | 同一套服务的自签名证书版（对比学习用） |
| `traefik/lets-encrypt` | Let's Encrypt 自动签发版 |

> `traefik/http` 动态配置在 `dynamic-conf/` 下按服务拆分，并依赖 `traefik-net` 网络。
> 其它服务大多声明 `networks: traefik-net (external: true)`，需先启动任一 traefik 变体创建该网络。

## 服务清单

| 目录 | 服务 | 访问端口 / 说明 |
| --- | --- | --- |
| `adguard` | AdGuard Home | host 网络，DNS/广告过滤 |
| `authelia` | Authelia | SSO / 身份认证，配置在 `config/` |
| `gerrit` | Gerrit | 代码评审 |
| `grafana` | Grafana | 监控可视化，admin/admin |
| `homarr` | Homarr | 自托管导航面板 |
| `homeassistant` | Home Assistant | smart home，host 网络（`privileged`） |
| `jenkins` | Jenkins | CI/CD |
| `ldap` / `lldap` | OpenLDAP / LLDAP | 轻量目录认证（两套可选） |
| `mongo` | MongoDB + mongo-express | 见下方「同一目录多文件」 |
| `nextcloud` | Nextcloud | 见下方「同一目录多文件」 |
| `nginx` | Nginx | 静态站 / 反代示例 |
| `phpmyadmin` | phpMyAdmin | MySQL 管理 |
| `portainer` | Portainer | 容器管理面板 |
| `postgres` | PostgreSQL + adminer | 含 `pg_isready` healthcheck |
| `prometheus` | Prometheus | 指标采集，配置在 `prometheus.yml` |
| `redis` | Redis (redismod) + RedisInsight | 含 `redis-cli ping` healthcheck |
| `sonar` | SonarQube | 静态代码分析 |
| `uptime-kuma` | Uptime Kuma | 可用性监控，挂载 docker.sock 用于 Docker 检测 |

## 同一目录多文件（避免混淆）

- **mongo/**：`compose.yml`（精简版）与 `docker-compose.yml`（完整版，带 healthcheck / 独立网络，
  推荐用这个）功能重叠且端口相同，仅作学习对比，别同时启动。
- **nextcloud/**：`docker-compose.yml`（linuxserver 镜像，需配好外部 DB/Traefik）与
  `aio-compose.yml`（Nextcloud AIO 官方 all-in-one，自动拉起配套组件，推荐用这个）。

## 说明

- 文件名统一为 `compose.yml`（旧 `docker-compose.yml` 已迁移）。
- 涉及宿主机 IP 的服务：`adguard`、`homeassistant`、`traefik/http`。
