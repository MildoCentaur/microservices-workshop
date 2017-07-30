FROM frolvlad/alpine-oraclejdk8:slim
ADD ["target/catalog-service-0.0.1-SNAPSHOT.jar", "app.jar"]
EXPOSE 8181
RUN sh -c 'touch /app.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker -jar /app.jar" ]
