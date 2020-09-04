FROM openjdk:8
RUN mkdir /app
COPY warehouse-1.0-SNAPSHOT.jar /app
WORKDIR /app
ENTRYPOINT ["java","-jar", "warehouse-1.0-SNAPSHOT.jar"]