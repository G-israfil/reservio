FROM openjdk:20
LABEL authors="israfil_gzdl"

COPY target/eureka-server.jar eureka-server.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar", "eureka-server.jar"]