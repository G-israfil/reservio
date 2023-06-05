FROM openjdk:20-oracle
LABEL authors="israfil_gzdl"

COPY target/order-management.jar order-management.jar
EXPOSE 9001
ENTRYPOINT ["java","-jar", "order-management.jar"]