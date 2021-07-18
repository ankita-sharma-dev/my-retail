FROM openjdk:8-jre-alpine
VOLUME /tmp
ARG JAR_FILE
COPY /target/${JAR_FILE} /product-price.jar
CMD ["/usr/bin/java", "-Dspring.profiles.active=$PROFILE", "-jar", "/product-price.jar"]
EXPOSE 8080