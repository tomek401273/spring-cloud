#FROM adoptopenjdk/maven-openjdk11:latest
#
#WORKDIR /home/tomek
#RUN apt-get update
#RUN apt-get install -y vim
#
#COPY ./pom.xml .
#COPY ./src/main/java/com/tgrajkowski/authortization/AuthorizationServerApplication.java ./src/main/java/com/tgrajkowski/authortization/AuthorizationServerApplication.java
#RUN mvn install
#
#COPY . .
##CMD ["tail", "-f", "/dev/null"]
#CMD ["mvn", "spring-boot:run"]

FROM adoptopenjdk/openjdk11
WORKDIR /home/tomek
#COPY ./target/authorization-server-0.0.1-SNAPSHOT.jar ./app.jar
COPY ./target/zuul-0.0.1-SNAPSHOT.jar ./app.jar
CMD ["java", "-jar", "app.jar"]
