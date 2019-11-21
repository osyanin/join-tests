package ru.joinrpg.tests.gui;

import ru.joinrpg.tests.core.TestBase;
import ru.joinrpg.tests.core.utils.login.LoginPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

class Login extends TestBase {

    @Test
    void positive() {
        LoginPage loginPage = open("/account/login", LoginPage.class);
        loginPage.inputValues(master.mail, master.password).pressLogIn();

    }
}
