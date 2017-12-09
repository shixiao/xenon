FROM maven:3.5-jdk-8-alpine
MAINTAINER Xiao Shi <xshi0x63@gmail.com>

EXPOSE 8080
EXPOSE 80

# Copy jar
# RUN mkdir -p /usr/app/xenon-web/target
# WORKDIR /usr/app/xenon-web
# ADD target/xenon-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/app/xenon-web/target

######## This does not work...
# Copy src
RUN mkdir -p /usr/app/xenon-web/
WORKDIR /usr/app/xenon-web
ADD . /usr/app/xenon-web

RUN cd /usr/app/xenon-web
RUN mvn clean package
CMD ["java", "-jar", "/usr/app/xenon-web/target/xenon-1.0-SNAPSHOT-jar-with-dependencies.jar"]
