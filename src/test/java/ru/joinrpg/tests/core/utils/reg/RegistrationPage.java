package ru.joinrpg.tests.core.utils.reg;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {

    public RegistrationSuccessPage newUser(String mail, String password) {
        enterEmail(mail).is(text(mail));
        enterPassword(password).is(not(empty));
        confirmPassword(password).is(not(empty));
        rulesAccept().click();
        registrationConfirm();
        return page(RegistrationSuccessPage.class);
    }

    public RegistrationPage notAcceptedAgreementUser(String mail, String password) {
        enterEmail(mail);
        enterPassword(password);
        confirmPassword(password);
        registrationConfirm();
        return page(RegistrationPage.class);
    }

    public RegistrationPage notEnteredMailAndPasswordUser() {
        registrationConfirm();
        return page(RegistrationPage.class);
    }


    public SelenideElement notAcceptedAgreementMessage() {
        return $(byText("Согласитесь с правилами, чтобы продолжить"));
    }

    public SelenideElement noEmailMessage() {
        return $(byText("The Email field is required."));
    }

    public SelenideElement noPasswordMessage() {
        return $(byText("The Пароль field is required."));
    }

    private SelenideElement enterEmail(String mail) {
        return $("#Email").setValue(mail);
    }

    private SelenideElement enterPassword(String password) {
        return $("#Password").setValue(password);
    }

    private SelenideElement confirmPassword(String password) {
        return $("#ConfirmPassword").setValue(password);
    }

    private SelenideElement rulesAccept() {
        return $("#RulesApproved");
    }

    private void registrationConfirm() {
        $(byValue("Зарегистрироваться")).click();
    }
    
}
