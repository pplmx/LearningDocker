# 完整家庭自托管应用清单

## 🎯 反向代理 & 网关

```bash
192.168.31.109 traefik.x.internal         # Traefik（现代化反向代理）
192.168.31.109 nginx.x.internal           # Nginx Proxy Manager（图形化管理）
192.168.31.109 caddy.x.internal           # Caddy（自动HTTPS）
192.168.31.109 authelia.x.internal        # Authelia（统一身份认证）
192.168.31.109 authentik.x.internal       # Authentik（身份提供商）
```

## 📊 系统监控 & 运维

```bash
# 基础监控
192.168.31.109 uptime.x.internal          # Uptime Kuma（服务监控）
192.168.31.109 statping.x.internal        # Statping（状态页面）
192.168.31.109 grafana.x.internal         # Grafana（数据可视化）
192.168.31.109 prometheus.x.internal      # Prometheus（指标收集）
192.168.31.109 loki.x.internal            # Loki（日志聚合）

# 系统信息
192.168.31.109 netdata.x.internal         # Netdata（实时系统监控）
192.168.31.109 glances.x.internal         # Glances（系统信息）
192.168.31.109 homer.x.internal           # Homer（服务首页）
192.168.31.109 heimdall.x.internal        # Heimdall（应用仪表板）
192.168.31.109 homarr.x.internal          # Homarr（现代化仪表板）
192.168.31.109 organizr.x.internal        # Organizr（服务整合）
192.168.31.109 flame.x.internal           # Flame（自托管起始页）
```

## 🐳 容器管理

```bash
192.168.31.109 portainer.x.internal       # Portainer（容器管理界面）
192.168.31.109 yacht.x.internal           # Yacht（轻量级容器管理）
192.168.31.109 dockge.x.internal          # Dockge（Docker Compose管理）
192.168.31.109 lazydocker.x.internal      # LazyDocker（终端容器管理）
```

## 🏠 智能家居 & 自动化

```bash
# 核心平台
192.168.31.109 ha.x.internal              # Home Assistant（智能家居中枢）
192.168.31.109 openhab.x.internal         # OpenHAB（开源家居平台）
192.168.31.109 domoticz.x.internal        # Domoticz（轻量级家居系统）
192.168.31.109 iobroker.x.internal        # ioBroker（德国开源平台）

# 自动化 & 通信
192.168.31.109 nodered.x.internal         # Node-RED（可视化编程）
192.168.31.109 mqtt.x.internal            # MQTT Broker（消息中间件）
192.168.31.109 mosquitto.x.internal       # Eclipse Mosquitto（轻量MQTT）
192.168.31.109 emqx.x.internal            # EMQX（企业级MQTT）

# 设备集成
192.168.31.109 zigbee2mqtt.x.internal     # Zigbee2MQTT（Zigbee桥接）
192.168.31.109 zwavejs.x.internal         # Z-Wave JS（Z-Wave控制）
192.168.31.109 deconz.x.internal          # deCONZ（Zigbee网关）
192.168.31.109 esphome.x.internal         # ESPHome（ESP设备管理）
192.168.31.109 tasmota.x.internal         # Tasmota（设备固件管理）
```

## 📱 移动设备 & 推送

```bash
192.168.31.109 ntfy.x.internal            # ntfy（推送通知服务）
192.168.31.109 gotify.x.internal          # Gotify（自托管推送）
192.168.31.109 pushover.x.internal        # Pushover（通知服务）
192.168.31.109 apprise.x.internal         # Apprise（通知聚合）
```

## ☁️ 个人云存储 & 文件管理

```bash
# 云存储
192.168.31.109 nextcloud.x.internal       # Nextcloud（功能完整的云平台）
192.168.31.109 owncloud.x.internal        # ownCloud（企业级云存储）
192.168.31.109 seafile.x.internal         # Seafile（高性能文件同步）
192.168.31.109 pydio.x.internal           # Pydio（企业文件共享）

# 文件同步
192.168.31.109 syncthing.x.internal       # Syncthing（P2P文件同步）
192.168.31.109 resilio.x.internal         # Resilio Sync（商业同步）

# 文件管理器
192.168.31.109 filebrowser.x.internal     # File Browser（Web文件管理）
192.168.31.109 filerun.x.internal         # FileRun（类Google Drive界面）
192.168.31.109 tiny.x.internal            # Tiny File Manager（轻量级）
```

## 🎬 媒体服务器 & 娱乐

```bash
# 媒体服务器
192.168.31.109 jellyfin.x.internal        # Jellyfin（开源媒体服务器）
192.168.31.109 plex.x.internal            # Plex（商业媒体服务器）
192.168.31.109 emby.x.internal            # Emby（功能丰富的媒体服务器）
192.168.31.109 kodi.x.internal            # Kodi（媒体中心）

# 音乐服务
192.168.31.109 airsonic.x.internal        # Airsonic（音乐流媒体）
192.168.31.109 navidrome.x.internal       # Navidrome（现代音乐服务器）
192.168.31.109 mstream.x.internal         # mStream（简单音乐服务器）
192.168.31.109 ampache.x.internal         # Ampache（音乐管理）

# 播客 & 有声读物
192.168.31.109 audiobookshelf.x.internal  # AudioBookshelf（有声读物服务器）
192.168.31.109 podgrab.x.internal         # PodGrab（播客管理）
192.168.31.109 antennapod.x.internal      # AntennaPod（播客客户端）
```

## 📥 下载 & 媒体管理

```bash
# 下载工具
192.168.31.109 qbittorrent.x.internal     # qBittorrent（BitTorrent客户端）
192.168.31.109 transmission.x.internal    # Transmission（轻量级下载）
192.168.31.109 deluge.x.internal          # Deluge（功能丰富的下载器）
192.168.31.109 rutorrent.x.internal       # ruTorrent（Web界面）

# 媒体管理自动化
192.168.31.109 sonarr.x.internal          # Sonarr（电视剧管理）
192.168.31.109 radarr.x.internal          # Radarr（电影管理）
192.168.31.109 lidarr.x.internal          # Lidarr（音乐管理）
192.168.31.109 readarr.x.internal         # Readarr（电子书管理）
192.168.31.109 prowlarr.x.internal        # Prowlarr（索引器管理）
192.168.31.109 bazarr.x.internal          # Bazarr（字幕管理）

# 媒体工具
192.168.31.109 tdarr.x.internal           # Tdarr（媒体转码）
192.168.31.109 handbrake.x.internal       # HandBrake（视频压缩）
```

## 📸 相册 & 照片管理

```bash
192.168.31.109 photoprism.x.internal      # PhotoPrism（AI相册管理）
192.168.31.109 immich.x.internal          # Immich（现代相册应用）
192.168.31.109 lychee.x.internal          # Lychee（简洁相册）
192.168.31.109 piwigo.x.internal          # Piwigo（功能完整的相册）
192.168.31.109 chevereto.x.internal       # Chevereto（图片托管）
```

## 🔐 网络安全 & 隐私

```bash
# DNS & 广告拦截
192.168.31.109 adguard.x.internal         # AdGuard Home（DNS+广告拦截）
192.168.31.109 pihole.x.internal          # Pi-hole（轻量级广告拦截）
192.168.31.109 unbound.x.internal         # Unbound（递归DNS）
192.168.31.109 blocky.x.internal          # Blocky（现代DNS代理）

# VPN & 远程访问
192.168.31.109 wireguard.x.internal       # WireGuard（现代VPN）
192.168.31.109 openvpn.x.internal         # OpenVPN（传统VPN）
192.168.31.109 tailscale.x.internal       # Tailscale（零配置VPN）
192.168.31.109 headscale.x.internal       # Headscale（自托管Tailscale）
192.168.31.109 pritunl.x.internal         # Pritunl（企业VPN）

# 网络工具
192.168.31.109 guacamole.x.internal       # Apache Guacamole（远程桌面网关）
192.168.31.109 meshcentral.x.internal     # MeshCentral（远程管理）
```

## 💾 备份 & 数据保护

```bash
192.168.31.109 duplicati.x.internal       # Duplicati（增量备份）
192.168.31.109 restic.x.internal          # Restic（快速备份）
192.168.31.109 borg.x.internal            # BorgBackup（去重备份）
192.168.31.109 kopia.x.internal           # Kopia（现代备份工具）
192.168.31.109 urbackup.x.internal        # UrBackup（客户端备份）
```

## 🗄️ 数据库服务

```bash
192.168.31.109 mysql.x.internal           # MySQL（关系数据库）
192.168.31.109 postgres.x.internal        # PostgreSQL（高级关系数据库）
192.168.31.109 redis.x.internal           # Redis（内存数据库）
192.168.31.109 mongo.x.internal           # MongoDB（文档数据库）
192.168.31.109 mariadb.x.internal         # MariaDB（MySQL替代品）
192.168.31.109 phpmyadmin.x.internal      # phpMyAdmin（MySQL管理）
192.168.31.109 adminer.x.internal         # Adminer（轻量数据库管理）
```

## 📝 文档 & 知识管理

```bash
# Wiki & 知识库
192.168.31.109 bookstack.x.internal       # BookStack（自托管Wiki）
192.168.31.109 dokuwiki.x.internal        # DokuWiki（无数据库Wiki）
192.168.31.109 tiddlywiki.x.internal      # TiddlyWiki（个人笔记）
192.168.31.109 outline.x.internal         # Outline（团队知识库）
192.168.31.109 siyuan.x.internal          # SiYuan（思源笔记）

# 笔记应用
192.168.31.109 joplin.x.internal          # Joplin Server（同步服务器）
192.168.31.109 trilium.x.internal         # Trilium（分层笔记）
192.168.31.109 obsidian.x.internal        # Obsidian Sync（知识图谱）

# 文档协作
192.168.31.109 onlyoffice.x.internal      # OnlyOffice（Office套件）
192.168.31.109 collabora.x.internal       # Collabora Online（LibreOffice在线）
```

## 📧 通信 & 社交

```bash
# 邮件服务器
192.168.31.109 mailcow.x.internal         # Mailcow（完整邮件解决方案）
192.168.31.109 mailu.x.internal           # Mailu（简化邮件服务器）
192.168.31.109 iredmail.x.internal        # iRedMail（企业邮件）
192.168.31.109 roundcube.x.internal       # Roundcube（Web邮件客户端）

# 即时通讯
192.168.31.109 matrix.x.internal          # Matrix（去中心化聊天）
192.168.31.109 rocket.x.internal          # Rocket.Chat（团队协作）
192.168.31.109 mattermost.x.internal      # Mattermost（Slack替代）
192.168.31.109 zulip.x.internal           # Zulip（线程化聊天）

# 社交媒体
192.168.31.109 mastodon.x.internal        # Mastodon（微博客）
192.168.31.109 diaspora.x.internal        # Diaspora（去中心化社交）
```

## 💰 财务 & 生活管理

```bash
192.168.31.109 firefly.x.internal         # Firefly III（个人财务管理）
192.168.31.109 actual.x.internal          # Actual Budget（预算管理）
192.168.31.109 budge.x.internal           # Budge（简单预算工具）
192.168.31.109 grocy.x.internal           # Grocy（家庭管理）
192.168.31.109 mealie.x.internal          # Mealie（食谱管理）
```

## 🎮 游戏 & 娱乐

```bash
192.168.31.109 pterodactyl.x.internal     # Pterodactyl（游戏服务器面板）
192.168.31.109 minecraft.x.internal       # Minecraft服务器
192.168.31.109 steamcache.x.internal      # Steam缓存服务器
```

## 🛠️ 开发 & 工具

```bash
# 开发环境
192.168.31.109 vscode.x.internal          # VS Code Server（Web IDE）
192.168.31.109 code-server.x.internal     # Code Server（VSCode Web版）
192.168.31.109 gitea.x.internal           # Gitea（轻量Git服务）
192.168.31.109 gitlab.x.internal          # GitLab（完整DevOps平台）
192.168.31.109 forgejo.x.internal         # Forgejo（Gitea分支）

# CI/CD
192.168.31.109 drone.x.internal           # Drone（CI/CD平台）
192.168.31.109 jenkins.x.internal         # Jenkins（自动化服务器）
192.168.31.109 woodpecker.x.internal      # Woodpecker CI（轻量级CI）

# 项目管理
192.168.31.109 redmine.x.internal         # Redmine（项目管理）
192.168.31.109 taiga.x.internal           # Taiga（敏捷项目管理）
192.168.31.109 kanboard.x.internal        # Kanboard（看板工具）
```

## 🌐 网络服务

```bash
# Web服务器
192.168.31.109 apache.x.internal          # Apache HTTP Server
192.168.31.109 lighttpd.x.internal        # Lighttpd（轻量Web服务器）

# 文件共享
192.168.31.109 samba.x.internal           # Samba（SMB/CIFS）
192.168.31.109 nfs.x.internal             # NFS（网络文件系统）
192.168.31.109 ftp.x.internal             # FTP服务器

# 网络工具
192.168.31.109 speedtest.x.internal       # LibreSpeed（网速测试）
192.168.31.109 smokeping.x.internal       # SmokePing（网络延迟监控）
```

## 🤖 AI & 机器学习

```bash
192.168.31.109 ollama.x.internal          # Ollama（本地LLM）
192.168.31.109 openwebui.x.internal       # Open WebUI（LLM界面）
192.168.31.109 stable-diffusion.x.internal # Stable Diffusion（AI绘画）
192.168.31.109 jupyter.x.internal         # Jupyter Notebook（数据科学）
```

## 📦 其他实用工具

```bash
# 链接管理
192.168.31.109 linkding.x.internal        # Linkding（书签管理）
192.168.31.109 shaarli.x.internal         # Shaarli（链接分享）

# 短链接
192.168.31.109 yourls.x.internal          # YOURLS（短链接服务）
192.168.31.109 polr.x.internal            # Polr（现代短链接）

# 密码管理
192.168.31.109 vaultwarden.x.internal     # Vaultwarden（Bitwarden服务器）
192.168.31.109 passbolt.x.internal        # Passbolt（团队密码管理）

# 其他
192.168.31.109 excalidraw.x.internal      # Excalidraw（手绘风格图表）
192.168.31.109 draw.x.internal            # Draw.io（流程图工具）
192.168.31.109 etherpad.x.internal        # Etherpad（协作编辑器）
```

## 📱 建议的DNS配置策略

### 🚀 新手推荐（10-15个服务）

建议从核心服务开始，逐步添加其他功能

### 🔧 进阶用户（20-30个服务）

可以根据具体需求选择相应类别的应用

### 💪 高级用户（30+个服务）

构建完整的家庭数据中心，需要足够的硬件资源支持

### 💡 部署建议

1. **分阶段部署**：不要一次性部署所有服务
2. **资源监控**：确保硬件资源充足
3. **备份重要**：定期备份配置和数据
4. **安全第一**：只暴露必要的服务到外网
5. **文档记录**：记录各服务的配置和用途
