FROM ogion/firstandonly:probe
CMD cd /home/seluser/join-tests
CMD ./gradlew
