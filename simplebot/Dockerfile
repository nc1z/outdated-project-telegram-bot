FROM maven:3.8.7-openjdk-18 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

FROM openjdk:18-jdk-alpine
ARG JAR_FILE=target/*.jar
ARG BOT_KEY
ARG BOT_USERNAME
ENV ENV_BOT_KEY=$BOT_KEY
ENV ENV_BOT_USERNAME=$BOT_USERNAME
COPY --from=build ./target/simplebot-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]