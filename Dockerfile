FROM openjdk:8-jdk-alpine

LABEL maintanier="agrippa.wia@gmail.com"

VOLUME /tmp

EXPOSE 9000

ARG JAR_FILE=target/Silion-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} Silion.jar

ENTRYPOINT ["java", "-jar","/Silion.jar"]

