package ru.joinrpg.uitests.models.login;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.joinrpg.uitests.models.main.MainPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    public LoginPage inputValues(String email, String password) {
        enterMail(email).is(text(email));
        enterPassword(password).is(not(empty));
        return page(LoginPage.class);
    }

    @Step()
    public MainPage authorize(String email, String password) {
        enterMail(email).is(text(email));
        enterPassword(password).is(not(empty));
        pressLogIn();
        return page(MainPage.class);
    }
    @Step
    private SelenideElement enterMail(String mail) {
        return $("#Email").setValue(mail);
    }
    @Step
    private SelenideElement enterPassword(String password) { return $("#Password").setValue(password); }
    @Step
    public void pressLogIn() { $(byValue("Войти")).click();}
}
