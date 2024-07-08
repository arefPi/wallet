FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/wallet.jar wallet.jar
ENTRYPOINT ["java","-jar","/wallet.jar"]