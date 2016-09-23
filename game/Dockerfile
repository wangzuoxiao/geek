FROM docker.yihecloud.com/base/java:8_60

MAINTAINER Niekq niekongquan@yihecloud.com

WORKDIR /program

COPY docker/startup.sh /program/startup.sh
RUN chmod +x /program/startup.sh \
	&& sed -i "3i export JETTY_WEB_VERSION=1.0_`date +%Y%m%d%H%M%S`" /program/startup.sh

COPY target/game-jetty-1.0.0-bin.tar.gz /program/game-jetty-1.0.0-bin.tar.gz

CMD /program/startup.sh
