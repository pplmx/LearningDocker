# syntax=docker/dockerfile:1
FROM rockylinux:9
LABEL maintainer="Mystic"
LABEL README="A RockyLinux:9 with ohmyzsh + starship"

RUN dnf upgrade --refresh -y  \
    # util-linux-user for chsh command
    && dnf install -y zsh util-linux-user which git \
    && dnf clean all \
  	&& rm -rf /var/cache/yum
RUN chsh -s $(which zsh) $(whoami)
# RUN sh -c "$(curl -fsSL https://raw.github.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
RUN sh -c "$(curl -fsSL https://gitee.com/mirrors/oh-my-zsh/raw/master/tools/install.sh)"
RUN curl -sS https://starship.rs/install.sh | sh -s -- --yes
RUN echo "eval \"$(starship init zsh)\"" >> ~/.zshrc
