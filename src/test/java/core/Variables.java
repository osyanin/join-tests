package core;

import com.codeborne.selenide.SelenideDriver;

import java.io.File;
import java.util.Properties;

public class Variables {
    static Properties p = new Properties();

    static protected String URL;
    protected static String user;
    protected static String password;

    protected static SelenideDriver driver;

    private RandomGenerated generated = new RandomGenerated();

    protected File rabbitJpg = new File("src/test/resources/rabbit.jpg");
    protected File rabbitPdf = new File("src/test/resources/rabbit.pdf");

    private final String generatedCyrillicUpperCase = new RandomGenerated().cyryllicUpperCase(1);
    private final String generatedCyrillicLowerCase = new RandomGenerated().cyryllicLowerCase(9);
    protected final String generatedPhoneNumber = new RandomGenerated().phoneNumber888();
    protected final String generatedPassportNumber = new RandomGenerated().number(6);
    protected final String generatedEmail = generated.stringValue(10).toLowerCase() + "@grr.la";
}
