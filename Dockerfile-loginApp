FROM mavenqa.got.volvo.net:18443/openjdk:8

ADD /target/loginApp-0.0.1-SNAPSHOT.war loginApp-0.0.1-SNAPSHOT.war

EXPOSE 8000

ENTRYPOINT ["java", "-jar", "loginApp-0.0.1-SNAPSHOT.war"]