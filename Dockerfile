FROM openjdk:11
EXPOSE 8080
ADD target/event-posting.jar event-posting.jar
ENTRYPOINT ["java","-jar","/event-posting.jar"]






