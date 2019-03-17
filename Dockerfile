FROM elgalu/selenium
RUN apt install -y openjdk-8-jdk
WORKDIR /home/seluser/join-tests
RUN ./gradlew
