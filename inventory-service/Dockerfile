FROM joalvarezdev/springboot-alpine-17:latest

MAINTAINER joalvarez

COPY target/Inventory Service.jar .

EXPOSE 8090

ENTRYPOINT ["java","-jar","Inventory Service.jar"]
