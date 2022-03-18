FROM openjdk:11.0.4-jre-slim
VOLUME /tmp
COPY target/api-security-*.jar api-security.jar
CMD ["java", "-jar", "api-security.jar"]