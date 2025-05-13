# This is the base image
FROM maven:3.9.9-eclipse-temurin-21 AS builder

# specify the working direcotory
WORKDIR /app

# copy the pom.xml to the working directory
COPY pom.xml .

# cache the dependencies unless changes are detected, will make it faster
RUN mvn depedency:go-offline -B

# copy our source code over
COPY src ./src

# put everyting in a jar
RUN mvn clean package

# is a multi-stage build statement , the second stage uses the build artifact from the builder stage above
FROM openjdk:21-jdk AS runner

WORKDIR /app

# copy the patient-service snapshot jar that was created in the builder step
COPY --from=builder ./app/target/patient-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 4000

# This is the comand that will run when a container created from this image starts
# this will automatically run the Java application contained in teh app.jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
