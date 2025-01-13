FROM openjdk:21-jdk-slim
WORKDIR /app
COPY build/libs/InternshipAssignment-0.0.1-SNAPSHOT-plain.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
