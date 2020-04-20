FROM openjdk:11

COPY /target/prueba-tecnica-0.0.1-SNAPSHOT.jar prueba-tecnica-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "prueba-tecnica-0.0.1-SNAPSHOT.jar"]