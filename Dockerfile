FROM openjdk:11-jre-slim

WORKDIR app

COPY /target/restapi-test-project.jar .

CMD ["java", "-jar", "restapi-test-project.jar"]

