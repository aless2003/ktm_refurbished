FROM openjdk:17
ARG JAR_FILE=build/libs/ktm_refurbished-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]