package ru.joinrpg.uitests.tests;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import ru.joinrpg.uitests.models.reg.RegistrationPage;
import ru.joinrpg.uitests.models.reg.RegistrationSuccessPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.open;

class Registration extends TestBase{
    private static Logger logger = LoggerFactory.getLogger(CreateGame.class);

    @Test
    void positive() {
        RegistrationPage reg = open("/account/register", RegistrationPage.class);
        RegistrationSuccessPage registrationSuccessPage = reg.newUser(vars.getNewUserMail(), vars.getNewUserPassword());
        registrationSuccessPage.registrationSuccessCaption().should(exist);

    }

    @Test
    void notAcceptedAgreement() {
        RegistrationPage reg = open("/account/register", RegistrationPage.class);
        reg.notAcceptedAgreementUser(vars.getNewUserMail(), vars.getNewUserPassword()).notAcceptedAgreementMessage().should(exist);
    }

    @Test
    void notEnteredMailAndPassword() {
        RegistrationPage reg = open("/account/register", RegistrationPage.class);
        reg.notEnteredMailAndPasswordUser().noEmailMessage().should(exist);
        reg.noPasswordMessage().should(exist);
    }
}
