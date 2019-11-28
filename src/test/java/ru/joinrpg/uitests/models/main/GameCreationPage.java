package ru.joinrpg.uitests.models.main;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.joinrpg.uitests.models.project.MainProjectPage;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class GameCreationPage {
    @Step
    public MainProjectPage createRPG(String projectName) {
        fillProjectName(projectName).is(text(projectName));
        rulesApproved().click();
        rulesApproved().is(checked);
        projectTypeLARP().is(checked);
        createProjectButton().scrollTo().click();
        return page(MainProjectPage.class);
    }
    @Step
    public SelenideElement gameCreationCaption() {
        return $(byText("Создание базы заявок для новой игры"));
    }
    @Step
    private SelenideElement fillProjectName(String projectName) {
        return $("#ProjectName").setValue(projectName);
    }
    @Step
    private SelenideElement rulesApproved() {
        return $("#RulesApproved");
    }
    @Step
    private SelenideElement projectTypeLARP() {
        return $("#ProjectType_Larp");
    }
    @Step
    private SelenideElement createProjectButton() {
        return $(byValue("Создать базу заявок"));
    }
}
