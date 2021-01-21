FROM ubuntu
RUN apt-get update && \
    apt-get install -y maven && \
    apt-get install -y openjdk-11-jre openjdk-11-jdk && \
    apt-get install pandoc
COPY simplewebapp /simplewebapp
RUN mvn -f simplewebapp/ package
RUN sh simplewebapp/target/bin/simplewebapp
 

