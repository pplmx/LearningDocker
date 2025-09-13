# 家庭服务器 DNS 配置建议

## 🔥 核心必备服务（建议优先部署）

```bash
# 反向代理与容器管理
192.168.31.109 traefik.x.internal        # Traefik（统一入口，必需）
192.168.31.109 portainer.x.internal      # Portainer（容器管理界面）

# 系统监控
192.168.31.109 uptime.x.internal         # Uptime（服务状态监控）

# 智能家居核心
192.168.31.109 ha.x.internal             # Home Assistant（智能家居中枢）
192.168.31.109 mqtt.x.internal           # MQTT Broker（物联网通信）

# 网络安全
192.168.31.109 adh.x.internal            # AdGuard Home（广告拦截+DNS）

# 个人云存储
192.168.31.109 nextcloud.x.internal      # Nextcloud（文件同步和存储）

# 媒体服务
192.168.31.109 jellyfin.x.internal       # Jellyfin（家庭影音中心）
```

## 🌟 进阶服务（有需要再添加）

```bash
# 智能家居扩展
192.168.31.109 zigbee2mqtt.x.internal    # Zigbee2MQTT（智能设备接入）
192.168.31.109 nodered.x.internal        # Node-RED（自动化编程）

# 文件管理
192.168.31.109 syncthing.x.internal      # Syncthing（设备间文件同步）

# 媒体管理（如果需要自动化下载）
192.168.31.109 sonarr.x.internal         # Sonarr（电视剧管理）
192.168.31.109 radarr.x.internal         # Radarr（电影管理）
192.168.31.109 transmission.x.internal   # Transmission（下载工具）

# 远程访问
192.168.31.109 vpn.x.internal            # WireGuard VPN
```

## 📸 可选服务（根据兴趣添加）

```bash
# 相册管理
192.168.31.109 photoprism.x.internal     # PhotoPrism（智能相册）

# 音乐服务
192.168.31.109 airsonic.x.internal       # Airsonic（音乐流媒体）

# 家庭办公
192.168.31.109 bookstack.x.internal      # BookStack（家庭知识库）

# 备份
192.168.31.109 duplicati.x.internal      # Duplicati（数据备份）
```

## 🚫 可以暂时跳过的服务

以下服务对一般家庭用户来说可能过于复杂或重复：

- **nginx.x.internal** - 有了 Traefik 就够了
- **grafana.x.internal / prom.x.internal** - 监控过于复杂，Uptime 足够
- **pihole.x.internal** - AdGuard Home 已经包含此功能
- **unbound.x.internal** - AdGuard Home 内置 DNS 功能
- **tailscale.x.internal** - 与 WireGuard 功能重复
- **smb.x.internal / nfs.x.internal** - Nextcloud 已提供文件共享
- **frigate.x.internal / scrypted.x.internal** - 视频监控比较复杂
- **rhasspy.x.internal / wyoming.x.internal** - 语音助手配置复杂
- **fing.x.internal / nmap.x.internal** - 路由器通常已有此功能
- **code-server.x.internal** - 除非需要远程编程

## 📋 建议部署顺序

1. **第一阶段**：Traefik + Portainer + AdGuard Home
2. **第二阶段**：Home Assistant + MQTT + Uptime
3. **第三阶段**：Nextcloud + Jellyfin
4. **第四阶段**：根据需要添加其他服务

## 💡 温馨提示

- **硬件配置**：确保您的设备有足够的内存和存储空间
- **网络安全**：只对外暴露必要的服务
- **备份策略**：定期备份重要配置和数据
- **逐步部署**：不要一次性部署所有服务，先从核心服务开始
