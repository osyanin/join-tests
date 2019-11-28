package ru.joinrpg.uitests.models.project;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainProjectPage {
    @Step
    public SelenideElement projectActiveCaption() {
        return $(byText("Проект активен"));
    }
    @Step
    public SelenideElement claimsAcceptingIsClosedCaption() {
        return $(byText("Прием заявок закрыт"));
    }
}
