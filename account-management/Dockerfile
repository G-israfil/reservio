FROM openjdk:20-oracle
LABEL authors="israfil_gzdl"

COPY target/account-management.jar account-management.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar", "account-management.jar"]