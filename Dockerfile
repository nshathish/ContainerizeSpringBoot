FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 80

CMD ["java", "-jar", "app.jar", "--server.port=80"]