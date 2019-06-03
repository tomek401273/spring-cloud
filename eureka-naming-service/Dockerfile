FROM adoptopenjdk/maven-openjdk11:latest

#WORKDIR /home/tomek
#
#COPY . .
#RUN mvn install
#
#CMD ["tail", "-f", "/dev/null"]
#FROM adoptopenjdk/maven-openjdk11:latest
#
WORKDIR /home/tomek

COPY ./pom.xml .
COPY ./src/main/java/com/in28minutes/microservises/netflixeurekanamingserver/NetflixEurekaNamingServerApplication.java ./src/main/java/com/in28minutes/microservises/netflixeurekanamingserver/NetflixEurekaNamingServerApplication.java
RUN mvn install

COPY . .
CMD ["mvn", "spring-boot:run"]
#CMD ["tail", "-f", "/dev/null"]

#FROM adoptopenjdk/openjdk11
#WORKDIR /home/tomek
#COPY ./target/netflix-eureka-naming-server-0.0.1-SNAPSHOT.jar ./app.jar
#CMD ["java", "-jar", "app.jar"]
