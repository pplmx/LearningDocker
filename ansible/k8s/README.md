# Deploy k8s by Ansible

## ssh without authentication
```bash
ansible-playbook less-ssh.yml
```

## check the network
```bash
ansible -i hosts all -m ping
```

## try playbook

```bash
ansible-playbook -i hosts users.yml
```

## FYI

```bash
# generate a ssh key, if exists, overwrite it
ssh-keygen -q -t ed25519 -N '' -f ~/.ssh/wsl_2204_ed25519 -C "Some Comments" <<<$'\n' >/dev/null 2>&1

# ssh-copy-id without prompting
sshpass -p "YOUR_PASSWD" ssh-copy-id -f -i ~/.ssh/ansible_ed25519 -o StrictHostKeyChecking=no root@IP_OR_DOMAIN >/dev/null 2>&1
```
