FROM openjdk:20-oracle
LABEL authors="israfil_gzdl"

COPY target/product-catalog-management.jar product-catalog-management.jar
EXPOSE 9003
ENTRYPOINT ["java","-jar", "product-catalog-management.jar"]