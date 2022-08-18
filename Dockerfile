FROM openjdk:17-alpine

COPY ./target/ ./

CMD ["java", "-jar", "library-0.0.1-SNAPSHOT.jar"]