FROM openjdk:17
ADD build/libs/spring-boot-multitenant-partition-0.0.1-SNAPSHOT.jar tenant.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "tenant.jar"]
