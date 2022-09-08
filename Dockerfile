FROM openjdk:11
ADD target/diabetes-0.0.1.SNAPSHOT.jar diabetes-microservice-docker.jar
ENTRYPOINT ["java", "-jar", "diabetes-microservice-docker.jar"]