package core.utils.main;

import com.codeborne.selenide.SelenideElement;
import core.utils.project.MainProjectPage;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class GameCreationPage {
    public MainProjectPage createRPG(String projectName) {
        fillProjectName(projectName).is(text(projectName));
        rulesApproved().click();
        rulesApproved().is(checked);
        projectTypeLARP().is(checked);
        createProjectButton().scrollTo().click();
        return page(MainProjectPage.class);
    }

    public SelenideElement gameCreationCaption() {
        return $(byText("Создание базы заявок для новой игры"));
    }

    private SelenideElement fillProjectName(String projectName) {
        return $("#ProjectName").setValue(projectName);
    }

    private SelenideElement rulesApproved() {
        return $("#RulesApproved");
    }

    private SelenideElement projectTypeLARP() {
        return $("#ProjectType_Larp");
    }

    private SelenideElement createProjectButton() {
        return $(byValue("Создать базу заявок"));
    }
}
