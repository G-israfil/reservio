FROM openjdk:20-oracle
LABEL authors="israfil_gzdl"

COPY target/reservio-management.jar reservio-management.jar
EXPOSE 9005
ENTRYPOINT ["java","-jar", "reservio-management.jar"]