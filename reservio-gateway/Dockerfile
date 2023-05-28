FROM openjdk:20
LABEL authors="israfil"
EXPOSE 8080
ADD target/reservio-gateway.jar reservio-gateway.jar
ENTRYPOINT ["java", "-jar", "reservio-gateway.jar"]
