package ru.joinrpg.tests.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import ru.joinrpg.tests.core.utils.User;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {
    protected static SiteConnection siteConnection = SiteConnection.load();
    protected static User user = new User(siteConnection.user, siteConnection.password);
    protected static User master = new User(siteConnection.master, siteConnection.password);

    protected Variables vars = Variables.generate();

    @BeforeAll
    public static void setUp() {

        Configuration.baseUrl          = siteConnection.url;
        Configuration.browserSize      = "1920x1080";
        Configuration.browser          = System.getProperty("browser");
        Configuration.timeout          = 4000;
        Configuration.headless         = true;
        Configuration.holdBrowserOpen  = false;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }
}