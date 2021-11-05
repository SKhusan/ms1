# http://www.thezonemanager.com/2015/07/whats-so-special-about-devurandom.html
# https://www.evanjones.ca/jvm-mmap-pause.html

FROM openjdk:15-jdk-slim

ARG version=undefined
LABEL version=${version}

WORKDIR /
COPY build/libs/ms1-$version.jar /ms1.jar

USER nobody

VOLUME ["/tmp"]

EXPOSE 7070
EXPOSE 8080
EXPOSE 8081

ENTRYPOINT ["sh", "-c", "exec java ${JAVA_OPTS} -jar ms1.jar"]
