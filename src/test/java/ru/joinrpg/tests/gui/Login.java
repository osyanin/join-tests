package ru.joinrpg.tests.gui;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import ru.joinrpg.tests.core.TestBase;
import ru.joinrpg.tests.core.utils.login.LoginPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

class Login extends TestBase {
    private static Logger logger = LoggerFactory.getLogger(CreateGame.class);

    @Test
    void positive() {
        LoginPage loginPage = open("/account/login", LoginPage.class);
        loginPage.inputValues(master.mail, master.password).pressLogIn();

    }
}
