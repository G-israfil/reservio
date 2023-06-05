FROM openjdk:20-oracle
LABEL authors="israfil_gzdl"

COPY target/payment-management.jar payment-management.jar
EXPOSE 9002
ENTRYPOINT ["java","-jar", "payment-management.jar"]