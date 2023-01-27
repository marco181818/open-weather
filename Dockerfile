FROM openjdk:11.0.16
COPY build/libs/weather-0.0.1-SNAPSHOT.jar weather-0.0.1-SNAPSHOT.jar
EXPOSE  8080
ENTRYPOINT ["java","-jar","/weather-0.0.1-SNAPSHOT.jar"]