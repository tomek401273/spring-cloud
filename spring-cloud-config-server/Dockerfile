FROM adoptopenjdk/maven-openjdk11:latest

WORKDIR /home/tomek

COPY ./pom.xml .
COPY ./src/main/java/com/in28minutes/microservices/demo/DemoApplication.java ./src/main/java/com/in28minutes/microservices/demo/DemoApplication.java
RUN mvn install

COPY . .
CMD ["mvn", "spring-boot:run"]
##CMD ["tail", "-f", "/dev/null"]


#FROM adoptopenjdk/openjdk11
#WORKDIR /home/tomek
#COPY ./target/demo-0.0.1-SNAPSHOT.jar ./app.jar
#CMD ["java", "-jar", "app.jar"]
