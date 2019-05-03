#FROM adoptopenjdk/maven-openjdk11:latest
#
#WORKDIR /home/tomek
#RUN apt-get update
#RUN apt-get install -y vim
#
#COPY ./pom.xml .
#COPY ./src/main/java/com/in28minutes/microservices/currencyconversionservice/CurrencyConversionServiceApplication.java ./src/main/java/com/in28minutes/microservices/currencyconversionservice/CurrencyConversionServiceApplication.java
#RUN mvn install
#
#COPY . .
##CMD ["tail", "-f", "/dev/null"]
#CMD ["mvn", "spring-boot:run"]
FROM adoptopenjdk/openjdk11
WORKDIR /home/tomek
COPY ./target/currency-conversion-service-0.0.1-SNAPSHOT.jar ./app.jar
CMD ["java", "-jar", "app.jar"]