FROM ubuntu
RUN apt-get update && \
    apt-get install -y maven && \
    apt-get install -y openjdk-11-jre openjdk-11-jdk && \
    apt-get install -y pandoc
COPY . /simplewebapp
RUN mvn -f /simplewebapp package
ENV PORT=8080
CMD /bin/sh /simplewebapp/target/bin/simplewebapp
