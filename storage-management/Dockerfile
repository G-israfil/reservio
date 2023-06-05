FROM openjdk:20-oracle
LABEL authors="israfil_gzdl"

COPY target/storage-management.jar subscription-management.jar
EXPOSE 9007
ENTRYPOINT ["java","-jar", "subscription-management.jar"]