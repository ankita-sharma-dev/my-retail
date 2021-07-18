FROM openjdk:8-jre-alpine
VOLUME /tmp
ARG JAR_FILE
COPY /target/${JAR_FILE} /product-info.jar
CMD ["/usr/bin/java", "-Dspring.profiles.active=$PROFILE", "-jar", "/product-info.jar"]
EXPOSE 8080