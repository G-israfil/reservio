FROM openjdk:20-oracle
LABEL authors="israfil_gzdl"

COPY target/common.jar common.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar", "common.jar"]