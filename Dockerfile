FROM  amazoncorretto:11-alpine-jdk
MAINTAINER RU
COPY  target/completar-0.0.1.jar ru-back.jar  
ENTRYPOINT ["java","-jar","/ru-back.jar"] 
