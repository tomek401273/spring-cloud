FROM adoptopenjdk/maven-openjdk11:latest
WORKDIR /home/tomek

COPY ./pom.xml .
COPY src/main/java/com/tgrajkowski/authorization/AuthorizationServerApplication.java ./src/main/java/com/tgrajkowski/authorization/AuthorizationServerApplication.java
RUN mvn install

COPY . .
CMD ["mvn", "spring-boot:run"]
