FROM frolvlad/alpine-oraclejdk8:slim
ADD ["target/config-registry-server-0.0.1-SNAPSHOT.jar", "app.jar"]
EXPOSE 8888
RUN sh -c 'touch /app.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker -jar /app.jar" ]
