############################################################
# Dockerfile to build some common apps Installed Containers
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
RUN cd /home/pkgs/Python-3.7.2/; ./configure --prefix=/usr/local/python3 --enable-optimizations; make && make altinstall

# update packages
RUN yum update -y

CMD [ "bash" ]
