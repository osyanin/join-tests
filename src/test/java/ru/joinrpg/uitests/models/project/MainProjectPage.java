package ru.joinrpg.uitests.models.project;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainProjectPage {

    public SelenideElement projectActiveCaption() {
        return $(byText("Проект активен"));
    }

    public SelenideElement claimsAcceptingIsClosedCaption() {
        return $(byText("Прием заявок закрыт"));
    }
}
