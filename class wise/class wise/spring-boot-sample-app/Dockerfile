FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} sampleapp.jar
ENTRYPOINT ["java", "-jar", "/sampleapp.jar"]
EXPOSE 9001