FROM openjdk:20-jdk
COPY target/docker-spring-boot.jar docker-spring-boot.jar
ENTRYPOINT ["java", "-jar", "/docker-spring-boot.jar"]