# syntax=docker/dockerfile:1
FROM rockylinux:9
LABEL maintainer="Mystic"
LABEL README="A RockyLinux:9 with ohmyzsh + starship"

RUN dnf upgrade --refresh -y  \
    && dnf install -y zsh \
    && dnf clean all \
  	&& rm -rf /var/cache/yum
RUN chsh -s $(which zsh) $(whoami)
# RUN sh -c "$(curl -fsSL https://raw.github.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
RUN sh -c "$(curl -fsSL https://gitee.com/mirrors/oh-my-zsh/raw/master/tools/install.sh)"
RUN curl -sS https://starship.rs/install.sh | sh
RUN echo "eval \"$(starship init zsh)\"" >> ~/.zshrc

CMD [ "/usr/sbin/init" ]
