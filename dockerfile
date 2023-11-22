FROM openjdk:8

COPY target/java-inventory.jar java-inventory=.jar

ENTRYPOINT ["java", "-jar", "/java-inventory.jar"]