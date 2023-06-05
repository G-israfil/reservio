FROM openjdk:20-oracle
LABEL authors="israfil_gzdl"

COPY target/reservation-management.jar reservation-management.jar
EXPOSE 9004
ENTRYPOINT ["java","-jar", "reservation-management.jar"]