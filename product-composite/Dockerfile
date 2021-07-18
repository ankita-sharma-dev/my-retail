FROM openjdk:8-jre-alpine
VOLUME /tmp
ARG JAR_FILE
COPY /target/${JAR_FILE} /product-composite.jar
CMD ["/usr/bin/java", "-Dspring.profiles.active=$PROFILE", "-jar", "/product-composite.jar"]
EXPOSE 8080