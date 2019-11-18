package core;

import com.codeborne.selenide.SelenideDriver;

import java.io.File;

public class Variables {
    
    private static RandomGenerated generated = new RandomGenerated();

    protected File rabbitJpg = new File("src/test/resources/rabbit.jpg");
    protected File rabbitPdf = new File("src/test/resources/rabbit.pdf");

    private final String generatedCyrillicUpperCase = new RandomGenerated().cyryllicUpperCase(1);
    private final String generatedCyrillicLowerCase = new RandomGenerated().cyryllicLowerCase(9);
    protected final String generatedPhoneNumber = new RandomGenerated().phoneNumber888();
    protected final String generatedPassportNumber = new RandomGenerated().number(6);

    protected static String newUser             = generated.stringValue(8);
    protected static String newUserMail         = generated.stringValue(8).toLowerCase() + "@grr.la";
    protected static String newUserPassword     = generated.stringValue(16);

    protected static String newMaster           = generated.stringValue(10);
    protected static String newMasterMail       = generated.stringValue(10).toLowerCase() + "@grr.la";
    protected static String newMasterPassword   = generated.stringValue(20);

    protected static String newGameName  = "ПРИ_" + generated.cyryllicUpperCase(8);
    protected static String newConventName  = generated.cyryllicUpperCase(8) + "_кон";
    protected static SelenideDriver driver;

    
}
