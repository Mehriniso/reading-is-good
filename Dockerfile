FROM openjdk:11.0.3-slim-stretch
ADD target/readingisgood-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Duser.timezone=Europe/Istanbul","-jar","app.jar"]
