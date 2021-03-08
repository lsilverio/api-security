FROM openjdk:11.0.4-jre-slim
VOLUME /tmp
COPY target/ecommerce-produto-*.jar ecommerce-produto.jar
CMD ["java", "-jar", "ecommerce-produto.jar"]