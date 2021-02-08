FROM openjdk:11-jre
MAINTAINER Juan Fernando Huyhua
ADD /build/libs/reto2-0.0.1-SNAPSHOT.jar aplicacion.jar
EXPOSE 8085
RUN bash -c 'touch /aplicacion.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/aplicacion.jar"]
