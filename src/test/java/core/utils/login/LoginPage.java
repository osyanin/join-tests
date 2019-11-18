package core.utils.login;

import com.codeborne.selenide.SelenideElement;
import core.TestBase;
import core.utils.main.MainPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage extends TestBase {
    public LoginPage inputValues(String email, String password) {
        enterMail(email).is(text(email));
        enterPassword(password).is(not(empty));
        return page(LoginPage.class);
    }

    public MainPage authorize(String email, String password) {
        enterMail(email).is(text(email));
        enterPassword(password).is(not(empty));
        pressLogIn();
        return page(MainPage.class);
    }

    private SelenideElement enterMail(String mail) {
        return $("#Email").setValue(mail);
    }
    private SelenideElement enterPassword(String password) { return $("#Password").setValue(password); }
    public void pressLogIn() { $(byValue("Войти")).click();}
}
