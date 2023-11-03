#JDK version
FROM openjdk:17-alpine3.14

RUN mkdir "app"

COPY target/product-mgmt-cli-app-1.0-SNAPSHOT.jar /app

WORKDIR /app

CMD ["java", "-jar", "./product-mgmt-cli-app-1.0-SNAPSHOT.jar"]