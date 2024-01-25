# 베이스 이미지 지정, 베이스 이미지와 태그를 지정하면 registry(docker hub)에서 해당 이미지를 가져옴(Pull)
FROM openjdk:17-alpine

#
ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]