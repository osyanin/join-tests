package gui;

import core.TestBase;
import core.utils.login.LoginPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

class Login extends TestBase {

    @Test
    void positive() {
        LoginPage loginPage = open("/account/login", LoginPage.class);
        loginPage.inputValues(master.mail, master.password).pressLogIn();

    }
}
