FROM docker.demo.yihecloud.com/base/java8:2.0

MAINTAINER Niekq niekongquan@yihecloud.com

WORKDIR /program

COPY docker/startup.sh /program/startup.sh
RUN chmod +x /program/startup.sh \
	&& sed -i "3i export TOMCAT_DEMO_VERSION=1.0_`date +%Y%m%d%H%M%S`" /program/startup.sh

COPY target/tomcat-demo-1.3.6.RELEASE.jar /program/app.jar

CMD /program/startup.sh
