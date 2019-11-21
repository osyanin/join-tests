package ru.joinrpg.uitests.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import ru.joinrpg.uitests.conf.SiteConnection;
import ru.joinrpg.uitests.conf.SiteVariables;
import ru.joinrpg.uitests.models.User;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    protected static final SiteConnection siteConnection = SiteConnection.load();
    protected static final User user = new User(siteConnection.getUser(), siteConnection.getPassword());
    protected static final User master = new User(siteConnection.getMaster(), siteConnection.getPassword());

    protected final SiteVariables vars = SiteVariables.generate();

    @BeforeAll
    public static void setUp() {

        Configuration.baseUrl          = siteConnection.getUrl();
        Configuration.browserSize      = "1920x1080";
        Configuration.browser          = System.getProperty("browser");
        Configuration.timeout          = 4000;
        Configuration.headless         = true;
        Configuration.holdBrowserOpen  = false;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }
}