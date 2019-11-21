package ru.joinrpg.uitests.models;

public class User {
    private String mail;
    private String password;

    public User(String email, String pass) {
        mail = email;
        password = pass;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }
}
