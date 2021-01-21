FROM ubuntu
RUN apt-get update && \
    apt-get install -y maven openjdk-11-jre openjdk-11-jdk pandoc texlive-xetex
COPY . /simplewebapp
RUN mvn -f /simplewebapp package
ENV PORT=8080
CMD /bin/sh /simplewebapp/target/bin/simplewebapp
