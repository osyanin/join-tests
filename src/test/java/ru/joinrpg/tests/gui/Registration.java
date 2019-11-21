package ru.joinrpg.tests.gui;

import ru.joinrpg.tests.core.TestBase;
import ru.joinrpg.tests.core.utils.reg.RegistrationPage;
import ru.joinrpg.tests.core.utils.reg.RegistrationSuccessPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.open;

class Registration extends TestBase{

    @Test
    void positive() {
        RegistrationPage reg = open("/account/register", RegistrationPage.class);
        RegistrationSuccessPage registrationSuccessPage = reg.newUser(vars.newUserMail, vars.newUserPassword);
        registrationSuccessPage.registrationSuccessCaption().should(exist);

    }

    @Test
    void notAcceptedAgreement() {
        RegistrationPage reg = open("/account/register", RegistrationPage.class);
        reg.notAcceptedAgreementUser(vars.newUserMail, vars.newUserPassword).notAcceptedAgreementMessage().should(exist);
    }

    @Test
    void notEnteredMailAndPassword() {
        RegistrationPage reg = open("/account/register", RegistrationPage.class);
        reg.notEnteredMailAndPasswordUser().noEmailMessage().should(exist);
        reg.noPasswordMessage().should(exist);
    }
}
