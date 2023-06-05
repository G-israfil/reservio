FROM openjdk:20-oracle
LABEL authors="israfil_gzdl"

COPY target/restaurant-management.jar restaurant-management.jar
EXPOSE 9006
ENTRYPOINT ["java","-jar", "restaurant-management.jar"]