FROM openjdk:20
LABEL authors="israfil_gzdl"

COPY target/user-management.jar user-management.jar
EXPOSE 9009
ENTRYPOINT ["java","-jar", "user-management.jar"]