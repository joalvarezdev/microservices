FROM joalvarezdev/springboot-alpine-17:latest

MAINTAINER joalvarez

COPY target/API Gateway.jar .

EXPOSE 8090

ENTRYPOINT ["java","-jar","API Gateway.jar"]
