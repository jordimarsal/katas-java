FROM openjdk:17-jdk-slim-buster
WORKDIR /app

COPY ./target/katas-server-1.0.0-SNAPSHOT.jar /app/app.jar

ENTRYPOINT java -Duser.timezone=UTC -jar /app/app.jar