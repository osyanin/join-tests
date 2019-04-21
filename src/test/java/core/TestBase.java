package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.google.gson.Gson;
import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class TestBase {
    static public String URL;

    protected static Logger logger = LoggerFactory.getLogger(TestBase.class);

    private static WireMockServer wireMockServer = new WireMockServer(options().dynamicPort());
    protected static SelenideDriver driver;

    @BeforeAll
    public static void setUp() throws IOException {
        /*Properties p = new Properties();
        p.load(new FileInputStream("conf/" + System.getProperty("environment") + ".properties"));
        URL                            = p.getProperty("url");*/

        RestAssured.baseURI            = URL;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        Configuration.baseUrl          = URL;
        Configuration.browserSize      = "1920x1080";
        Configuration.browser          = System.getProperty("browser");
        Configuration.timeout          = 10000;
        Configuration.headless         = true;
        driver = new SelenideDriver(new SelenideConfig()
                .browserSize(Configuration.browserSize)
                .holdBrowserOpen(Configuration.holdBrowserOpen)
                .headless(Configuration.headless)
                .baseUrl(Configuration.baseUrl)
                .browser(Configuration.browser));

        RestAssured.filters(new AllureRestAssured());
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        System.setProperty("firefoxprofile.permissions.default.camera", "1");
        System.setProperty("firefoxprofile.browser.cache.disk.enable", "false");

        String CHROME_OPTIONS_ARGS = "chromeoptions.args";
        System.setProperty(CHROME_OPTIONS_ARGS, "--whitelisted-ips");

        wireMockServer.start();
        wireMockServer.stubFor(post(anyUrl())
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/plain")
                        .withBody("ok")));
    }

    private RandomGenerated generated = new RandomGenerated();
    private Base64 decoder = new Base64();
    protected Gson gson = new Gson();

    protected File rabbitJpg = new File("src/test/resources/rabbit.jpg");
    protected File rabbitPdf = new File("src/test/resources/rabbit.pdf");

    private final String generatedCyrillicUpperCase = new RandomGenerated().cyryllicUpperCase(1);
    private final String generatedCyrillicLowerCase = new RandomGenerated().cyryllicLowerCase(9);
    protected final String generatedPhoneNumber = new RandomGenerated().phoneNumber888();
    protected final String generatedPassportNumber = new RandomGenerated().number(6);
    protected final String generatedOrderId = generated.stringValue(12);
    protected final String generatedEmail = generated.stringValue(10).toLowerCase() + "@grr.la";

    @AfterAll
    public static void tearDown() {
        wireMockServer.stop();
    }

}
