############################################################
# Dockerfile to build python37 Installed Containers
# Based on rhel
############################################################

# Set the base image to rhel
FROM registry.access.redhat.com/rhel7

LABEL maintaner="purplemystic"

ENV MY_YUM_REPO /etc/yum.repos.d/my.repo
ENV GPG_KEY http://mirrors.aliyun.com/centos/RPM-GPG-KEY-CentOS-7
ENV YUM_REPO_ADDR http://mirrors.aliyun.com/centos
ENV ALIYUN_CENTOS_URL http://mirrors.aliyun.com/centos/7/os/x86_64/Packages/

# create directories
RUN mkdir -p /home/pkgs/; mkdir -p /usr/local/python3


# uninstall rhel yum, and to use centos yum
RUN rpm -qa | grep subscription-manager-* | xargs rpm -e
RUN rpm -qa | grep yum | xargs rpm -e
RUN rpm -ivh ${ALIYUN_CENTOS_URL}/yum-3.4.3-161.el7.centos.noarch.rpm ${ALIYUN_CENTOS_URL}/yum-plugin-fastestmirror-1.1.31-50.el7.noarch.rpm ${ALIYUN_CENTOS_URL}/yum-metadata-parser-1.1.4-10.el7.x86_64.rpm

# create your own yum source
RUN echo -e "[aliyun-base]\nname=aliyun-base\nbaseurl=${YUM_REPO_ADDR}/7/os/\$basearch/\nenabled=1\ngpgcheck=0\ngpgkey=${GPG_KEY}\n" >> ${MY_YUM_REPO}
RUN echo -e "[aliyun-extras]\nname=aliyun-extras\nbaseurl=${YUM_REPO_ADDR}/7/extras/\$basearch/\nenabled=1\ngpgcheck=0\ngpgkey=${GPG_KEY}\n" >> ${MY_YUM_REPO}
RUN echo -e "[aliyun-updates]\nname=aliyun-updates\nbaseurl=${YUM_REPO_ADDR}/7/updates/\$basearch/\nenabled=1\ngpgcheck=0\ngpgkey=${GPG_KEY}\n" >> ${MY_YUM_REPO}
RUN echo -e "[aliyun-centosplus]\nname=aliyun-centosplus\nbaseurl=${YUM_REPO_ADDR}/7/centosplus/\$basearch/\nenabled=1\ngpgcheck=0\ngpgkey=${GPG_KEY}\n" >> ${MY_YUM_REPO}


# clear cache
RUN yum clean all

# generate cache
RUN yum makecache

# install wget to download something
RUN yum install -y wget

# download python3.7 file to /home/pkgs/
RUN wget -P /home/pkgs/ https://www.python.org/ftp/python/3.7.2/Python-3.7.2.tgz
RUN tar -zxvf /home/pkgs/Python-3.7.2.tgz -C /home/pkgs/

# install python3.7 dependencies
# if without rebuilddb operation, it would throw ERROR 'Rpmdb checksum is invalid: dCDPT(pkg checksums)'
RUN rpm --rebuilddb && yum install -y gcc gcc-c++ libtool make zlib-devel bzip2-devel openssl-devel ncurses-devel sqlite-devel readline-devel tk-devel libffi-devel

# install python3.7 to /usr/local/python3
# Note that each instruction is run independently, and causes a new image to be created
# so RUN cd /tmp will not have any effect on the next instructions.
# I tried to execute it by one RUN command, however, installing python3 failed. Maybe it need to be executed separately.
RUN cd /home/pkgs/Python-3.7.2/; ./configure --prefix=/usr/local/python3
RUN cd /home/pkgs/Python-3.7.2/; ./configure --enable-optimizations
RUN cd /home/pkgs/Python-3.7.2/; make && make altinstall

# delete python source code
RUN rm -fr /home/pkgs/

# upgrade python
RUN rm -f /usr/bin/python
RUN ln -s /usr/local/bin/python3.7 /usr/bin/python3
RUN ln -s /usr/bin/python3 /usr/bin/python
RUN ln -s /usr/local/bin/pip3.7 /usr/bin/pip3
RUN ln -s /usr/bin/pip3 /usr/bin/pip

# enable yum
RUN sed -i 's@#!/usr/bin/python@#!/usr/bin/python2@g' /usr/bin/yum
RUN sed -i 's@#! /usr/bin/python@#!/usr/bin/python2@g' /usr/bin/yum
RUN sed -i 's@#!/usr/bin/python@#!/usr/bin/python2@g' /usr/libexec/urlgrabber-ext-down
RUN sed -i 's@#! /usr/bin/python@#!/usr/bin/python2@g' /usr/libexec/urlgrabber-ext-down

# install deltarpm to reduce the dependence on bandwidth, however, it will increase the burden on the CPU, when you update the packages
RUN yum install -y deltarpm

# update packages
RUN yum update -y

# upgrade pip
RUN pip install -U pip

CMD [ "/usr/sbin/init" ]
