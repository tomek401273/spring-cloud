#FROM adoptopenjdk/maven-openjdk11:latest
#WORKDIR /home/tomek
#
#COPY ./pom.xml .
#COPY ./src/main/java/com/tgrajkowski/authortization/AuthorizationServerApplication.java ./src/main/java/com/tgrajkowski/authortization/AuthorizationServerApplication.java
#RUN mvn install
#
#COPY . .
#CMD ["mvn", "spring-boot:run"]

FROM adoptopenjdk/maven-openjdk11:latest
WORKDIR /home/tomek
COPY ./target/authorization-server-0.0.1-SNAPSHOT.jar ./app.jar
CMD ["java", "-jar", "./app.jar"]

#FROM adoptopenjdk/maven-openjdk11:latest
#WORKDIR /home/tomek
#COPY . .
#CMD ["mvn", "spring-boot:run"]