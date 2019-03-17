FROM elgalu/selenium
RUN sudo apt update
RUN sudo apt install -y openjdk-8-jdk
CMD cd /home/seluser/join-tests
CMD ./gradlew
