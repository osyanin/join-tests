package ru.joinrpg.uitests.conf;

import ru.joinrpg.uitests.util.RandomGenerated;

import java.io.File;

public class SiteVariables {
    public File rabbitJpg;
    public File rabbitPdf;

    public String generatedCyrillicUpperCase;
    public String generatedCyrillicLowerCase;
    public String generatedPhoneNumber;
    public String generatedPassportNumber;

    public String newUser;
    public String newUserMail;
    public String newUserPassword;

    public String newMaster;
    public String newMasterMail;
    public String newMasterPassword;

    public String newGameName;
    public String newConventName;

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
}
