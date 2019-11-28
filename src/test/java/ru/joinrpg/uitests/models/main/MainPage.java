package ru.joinrpg.uitests.models.main;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    @Step
    public GameCreationPage newProject() {
        pressCreateProject();
        return page(GameCreationPage.class);
    }
    @Step
    private void pressCreateProject() {
        $(byText("Создать тестовую базу заявок")).click();
    }
}
