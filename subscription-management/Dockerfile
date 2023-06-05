FROM openjdk:20-oracle
LABEL authors="israfil_gzdl"

COPY target/subscription-management.jar subscription-management.jar
EXPOSE 9008
ENTRYPOINT ["java","-jar", "subscription-management.jar"]