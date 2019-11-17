package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class TestBase extends Variables {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeAll
    public static void setUp() throws IOException {
        propertyLoader();
        //System.setProperty(CHROME_OPTIONS_ARGS, "--whitelisted-ips\", \"--no-sandbox\", \"--disable-extensions\"");

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

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }

    private static void propertyLoader() throws IOException {
        p.load(new FileInputStream("conf/" + System.getProperty("conf", "test") + ".properties"));
        URL = p.getProperty("url");
        user = p.getProperty("user");
        password = p.getProperty("password");
    }
}