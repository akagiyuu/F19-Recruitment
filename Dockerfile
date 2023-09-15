FROM openjdk:17
EXPOSE 8080
ADD target/k19.jar k19.jar
ENTRYPOINT ["java", "-jar", "/k19.jar"]