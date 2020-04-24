FROM openjdk:8
ADD gateway.jar app.jar
EXPOSE 8000
CMD exec java -Xmx512m -Xms512m -Djava.security.egd=file:/dev/./urandom $PARAM -jar /app.jar