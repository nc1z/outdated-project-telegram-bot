FROM openjdk:19-jdk-alpine
ARG JAR_FILE=target/*.jar
ARG BOT_KEY
ARG BOT_USERNAME
ENV ENV_BOT_KEY=$BOT_KEY
ENV ENV_BOT_USERNAME=$BOT_USERNAME
COPY ./target/simplebot-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]