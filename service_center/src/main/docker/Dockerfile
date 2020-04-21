FROM openjdk:8
ADD service_center.jar app.jar
CMD exec java -Xmx512m -Xms512m -Djava.security.egd=file:/dev/./urandom $PARAM -jar /app.jar