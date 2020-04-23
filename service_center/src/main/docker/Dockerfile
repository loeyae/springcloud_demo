FROM openjdk:8
ADD service_center.jar app.jar
EXPOSE 9900
CMD exec java -Xmx512m -Xms512m -Djava.security.egd=file:/dev/./urandom $PARAM -jar /app.jar