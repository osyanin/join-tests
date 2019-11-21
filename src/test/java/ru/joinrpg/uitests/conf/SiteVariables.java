package ru.joinrpg.uitests.conf;

import ru.joinrpg.uitests.util.RandomGenerated;

import java.io.File;

public class SiteVariables {
    private File rabbitJpg;
    private File rabbitPdf;

    private String generatedCyrillicUpperCase;
    private String generatedCyrillicLowerCase;
    private String generatedPhoneNumber;
    private String generatedPassportNumber;

    private String newUser;
    private String newUserMail;
    private String newUserPassword;

    private String newMaster;
    private String newMasterMail;
    private String newMasterPassword;

    private String newGameName;
    private String newConventName;

    public static SiteVariables generate() {
        RandomGenerated generated = new RandomGenerated();
        SiteVariables vars = new SiteVariables();

        vars.rabbitJpg = new File("src/test/resources/rabbit.jpg");
        vars.rabbitPdf = new File("src/test/resources/rabbit.pdf");

        vars.generatedCyrillicUpperCase = new RandomGenerated().cyryllicUpperCase(1);
        vars.generatedCyrillicLowerCase = new RandomGenerated().cyryllicLowerCase(9);
        vars.generatedPhoneNumber = new RandomGenerated().phoneNumber888();
        vars.generatedPassportNumber = new RandomGenerated().number(6);

        vars.newUser = generated.stringValue(8);
        vars.newUserMail = generated.stringValue(8).toLowerCase() + "@grr.la";
        vars.newUserPassword = generated.stringValue(16);

        vars.newMaster = generated.stringValue(10);
        vars.newMasterMail = generated.stringValue(10).toLowerCase() + "@grr.la";
        vars.newMasterPassword = generated.stringValue(20);

        vars.newGameName = "ПРИ_" + generated.cyryllicUpperCase(8);
        vars.newConventName = generated.cyryllicUpperCase(8) + "_кон";

        return vars;
    }

    public File getRabbitJpg() {
        return rabbitJpg;
    }

    public void setRabbitJpg(File rabbitJpg) {
        this.rabbitJpg = rabbitJpg;
    }

    public File getRabbitPdf() {
        return rabbitPdf;
    }

    public void setRabbitPdf(File rabbitPdf) {
        this.rabbitPdf = rabbitPdf;
    }

    public String getGeneratedCyrillicUpperCase() {
        return generatedCyrillicUpperCase;
    }

    public void setGeneratedCyrillicUpperCase(String generatedCyrillicUpperCase) {
        this.generatedCyrillicUpperCase = generatedCyrillicUpperCase;
    }

    public String getGeneratedCyrillicLowerCase() {
        return generatedCyrillicLowerCase;
    }

    public void setGeneratedCyrillicLowerCase(String generatedCyrillicLowerCase) {
        this.generatedCyrillicLowerCase = generatedCyrillicLowerCase;
    }

    public String getGeneratedPhoneNumber() {
        return generatedPhoneNumber;
    }

    public void setGeneratedPhoneNumber(String generatedPhoneNumber) {
        this.generatedPhoneNumber = generatedPhoneNumber;
    }

    public String getGeneratedPassportNumber() {
        return generatedPassportNumber;
    }

    public void setGeneratedPassportNumber(String generatedPassportNumber) {
        this.generatedPassportNumber = generatedPassportNumber;
    }

    public String getNewUser() {
        return newUser;
    }

    public void setNewUser(String newUser) {
        this.newUser = newUser;
    }

    public String getNewUserMail() {
        return newUserMail;
    }

    public void setNewUserMail(String newUserMail) {
        this.newUserMail = newUserMail;
    }

    public String getNewUserPassword() {
        return newUserPassword;
    }

    public void setNewUserPassword(String newUserPassword) {
        this.newUserPassword = newUserPassword;
    }

    public String getNewMaster() {
        return newMaster;
    }

    public void setNewMaster(String newMaster) {
        this.newMaster = newMaster;
    }

    public String getNewMasterMail() {
        return newMasterMail;
    }

    public void setNewMasterMail(String newMasterMail) {
        this.newMasterMail = newMasterMail;
    }

    public String getNewMasterPassword() {
        return newMasterPassword;
    }

    public void setNewMasterPassword(String newMasterPassword) {
        this.newMasterPassword = newMasterPassword;
    }

    public String getNewGameName() {
        return newGameName;
    }

    public void setNewGameName(String newGameName) {
        this.newGameName = newGameName;
    }

    public String getNewConventName() {
        return newConventName;
    }

    public void setNewConventName(String newConventName) {
        this.newConventName = newConventName;
    }
}
