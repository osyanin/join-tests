package ru.joinrpg.tests.core;

import java.io.File;

public class Variables {

    public static RandomGenerated generated = new RandomGenerated();

    public File rabbitJpg = new File("src/test/resources/rabbit.jpg");
    public File rabbitPdf = new File("src/test/resources/rabbit.pdf");

    public final String generatedCyrillicUpperCase = new RandomGenerated().cyryllicUpperCase(1);
    public final String generatedCyrillicLowerCase = new RandomGenerated().cyryllicLowerCase(9);
    public final String generatedPhoneNumber = new RandomGenerated().phoneNumber888();
    public final String generatedPassportNumber = new RandomGenerated().number(6);

    public static String newUser = generated.stringValue(8);
    public static String newUserMail = generated.stringValue(8).toLowerCase() + "@grr.la";
    public static String newUserPassword = generated.stringValue(16);

    public static String newMaster = generated.stringValue(10);
    public static String newMasterMail = generated.stringValue(10).toLowerCase() + "@grr.la";
    public static String newMasterPassword = generated.stringValue(20);

    public static String newGameName = "ПРИ_" + generated.cyryllicUpperCase(8);
    public static String newConventName = generated.cyryllicUpperCase(8) + "_кон";
}
