FROM openjdk:11
EXPOSE 8081
ADD target/event-posting.jar event-posting.jar
ENTRYPOINT ["java","-jar","/event-posting.jar"]






