package ru.joinrpg.uitests.models.reg;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationSuccessPage {
    @Step
    public SelenideElement registrationSuccessCaption() {
        return $(byText("Регистрация успешна"));
    }
}
