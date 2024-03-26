FROM maven:latest AS build

COPY src /usr/src/app/src

COPY pom.xml /usr/src/app

RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:17

COPY --from=build /usr/src/app/target/springboot-mongodb-0.0.1-SNAPSHOT.jar /usr/app/springboot-mongodb-0.0.1-SNAPSHOT.jar

EXPOSE 5000

CMD ["java", "-jar", "/usr/app/springboot-mongodb-0.0.1-SNAPSHOT.jar"]
