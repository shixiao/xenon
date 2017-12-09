FROM maven:3.5-jdk-8-alpine
MAINTAINER Xiao Shi <xshi0x63@gmail.com>

# Copy source
RUN mkdir -p /usr/app/xenon-web
WORKDIR /usr/app/xenon-web
ADD . /usr/app/xenon-web

EXPOSE 8080

# Running Kotlin Application
CMD ["java", "-jar", "target/xenon-1.0-SNAPSHOT-jar-with-dependencies.jar"]
