FROM openjdk:20-oracle
LABEL authors="israfil_gzdl"

COPY target/user-management.jar user-management.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "user-management.jar"]