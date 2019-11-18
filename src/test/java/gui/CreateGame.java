package gui;

import core.TestBase;
import core.utils.login.LoginPage;
import core.utils.main.GameCreationPage;
import core.utils.project.MainProjectPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.open;

class CreateGame extends TestBase {
    @Test
    void positiveEndToEnd() {
        GameCreationPage gameCreationPage = open("/account/login", LoginPage.class)
                .authorize(master.mail, master.password)
                .newProject();

        MainProjectPage mainProjectPage = gameCreationPage.createRPG(newGameName);
        mainProjectPage.projectActiveCaption().isDisplayed();
        mainProjectPage.claimsAcceptingIsClosedCaption().isDisplayed();
        //TODO by master: add roles, configure fields, open claims, apply claim, add comment, reject claim.
        //TODO by user: send claim, add comment, pay, withdraw claim. I think there will be need two-three users.
    }

    @Test
    void fromMainPageToGameCreationPage() {
        open("/account/login", LoginPage.class)
                .authorize(master.mail, master.password)
                .newProject()
                .gameCreationCaption().is(exist);
    }
}
