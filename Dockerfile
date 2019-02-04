### STAGE 1: Build ###
FROM maven as build
ARG LOCAL_ENV=false
COPY ./src /app/src/
COPY ./pom.xml /app/
WORKDIR /app

RUN test $LOCAL_ENV="false" && mvn clean install

### STAGE 2: Setup ###
FROM openjdk:11.0.1-jdk-stretch
VOLUME /tmp
COPY --from=build /app/target/calculadora.jar calculadora.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/calculadora.jar"]


