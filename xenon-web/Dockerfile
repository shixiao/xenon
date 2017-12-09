FROM maven:3.5-jdk-8-alpine
MAINTAINER Xiao Shi <xshi0x63@gmail.com>

# Copy jar
RUN mkdir -p /usr/local/xenon-web/target
WORKDIR /usr/local/xenon-web
ADD target/xenon-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/local/xenon-web/target

ENTRYPOINT ["java", "-jar", "/usr/local/xenon-web/target/xenon-1.0-SNAPSHOT-jar-with-dependencies.jar"]
