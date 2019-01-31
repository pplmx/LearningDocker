############################################################
# Dockerfile to build python37 Installed Containers
# Based on centos
############################################################

# Set the base image to centos
FROM centos

LABEL maintaner="purplemystic"

# create directories
RUN mkdir -p /home/pkgs/; mkdir -p /usr/local/python3

# install epel source
RUN yum install -y epel-release

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
RUN yum install -y gcc gcc-c++ libtool make zlib-devel bzip2-devel openssl-devel ncurses-devel sqlite-devel readline-devel tk-devel libffi-devel

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
RUN sed -i 's@#!/usr/bin/python@#!/usr/bin/python2@g' /usr/libexec/urlgrabber-ext-down

# update packages
RUN yum update -y

# upgrade pip
RUN pip install -U pip

CMD [ "bash" ]

