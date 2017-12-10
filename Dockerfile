FROM maven:3.5-jdk-8-alpine
MAINTAINER Xiao Shi <xshi0x63@gmail.com>

ARG xenonVersion
ARG xenonWebVersion
RUN echo ${xenonVersion}
RUN echo ${xenonWebVersion}

RUN mkdir -p /usr/local/xenon/xenon-app/build/static
ADD xenon-app/build /usr/local/xenon/xenon-app/build/static
RUN mkdir -p /usr/local/xenon/xenon-web/target
WORKDIR /usr/local/xenon/xenon-web
ADD xenon-web/target/xenon-web-${xenonWebVersion}-jar-with-dependencies.jar /usr/local/xenon/xenon-web/target/xenon-web.jar

ENTRYPOINT ["java", "-jar", "/usr/local/xenon/xenon-web/target/xenon-web.jar"]
