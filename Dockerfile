FROM elgalu/selenium
RUN sudo apt update
RUN sudo apt install -y openjdk-8-jdk
RUN cd /home/seluser/join-tests
RUN ./gradlew
