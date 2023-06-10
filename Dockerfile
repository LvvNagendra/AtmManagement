FROM openjdk:8
EXPOSE 8080
ADD  target/Atm-managementSystem.jar Atm-managementSystem.jar
ENTRYPOINT [ "java","-jar","/Atm-managementSystem.jar" ]