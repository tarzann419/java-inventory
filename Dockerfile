#FROM openjdk:8
#
#COPY target/java-inventory.jar java-inventory=.jar
#
#ENTRYPOINT ["java", "-jar", "/java-inventory.jar"]

FROM openjdk:20
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/java-inventory-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

