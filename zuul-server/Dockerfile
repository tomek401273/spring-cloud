FROM adoptopenjdk/maven-openjdk11:latest

WORKDIR /home/tomek
RUN apt-get update
RUN apt-get install -y vim

COPY ./pom.xml .
COPY src/main/java/com/tgrajkowski/authorization/ZuulServerApplication.java ./src/main/java/com/tgrajkowski/authorization/ZuulServerApplication.java
RUN mvn install

COPY . .
CMD ["mvn", "spring-boot:run"]
