package ru.joinrpg.uitests.models.reg;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {
    @Step
    public RegistrationSuccessPage newUser(String mail, String password) {
        enterEmail(mail).is(text(mail));
        enterPassword(password).is(not(empty));
        confirmPassword(password).is(not(empty));
        rulesAccept().click();
        registrationConfirm();
        return page(RegistrationSuccessPage.class);
    }
    @Step
    public RegistrationPage notAcceptedAgreementUser(String mail, String password) {
        enterEmail(mail);
        enterPassword(password);
        confirmPassword(password);
        registrationConfirm();
        return page(RegistrationPage.class);
    }
    @Step
    public RegistrationPage notEnteredMailAndPasswordUser() {
        registrationConfirm();
        return page(RegistrationPage.class);
    }

    @Step
    public SelenideElement notAcceptedAgreementMessage() {
        return $(byText("Согласитесь с правилами, чтобы продолжить"));
    }
    @Step
    public SelenideElement noEmailMessage() {
        return $(byText("The Email field is required."));
    }
    @Step
    public SelenideElement noPasswordMessage() {
        return $(byText("The Пароль field is required."));
    }
    @Step
    private SelenideElement enterEmail(String mail) {
        return $("#Email").setValue(mail);
    }
    @Step
    private SelenideElement enterPassword(String password) {
        return $("#Password").setValue(password);
    }
    @Step
    private SelenideElement confirmPassword(String password) {
        return $("#ConfirmPassword").setValue(password);
    }
    @Step
    private SelenideElement rulesAccept() {
        return $("#RulesApproved");
    }
    @Step
    private void registrationConfirm() {
        $(byValue("Зарегистрироваться")).click();
    }
}
