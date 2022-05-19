FROM gradle:7.4.2-jdk17

COPY . /app

WORKDIR /app

RUN gradle bootJar

RUN ls

EXPOSE 80

ENTRYPOINT ["java", "-jar", "build/libs/ktm_refurbished-0.0.1-SNAPSHOT.jar"]
