package core.utils.reg;

import com.codeborne.selenide.SelenideElement;
import core.TestBase;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage extends TestBase {

    public RegistrationSuccessPage newUser(String mail, String password) {
        $("#Email").setValue(mail);
        $("#Password").setValue(password);
        $("#ConfirmPassword").setValue(password);
        $("#RulesApproved").click();
        $(byValue("Зарегистрироваться")).click();
        return page(RegistrationSuccessPage.class);
    }

    public RegistrationPage notAcceptedAgreementUser(String mail, String password) {
        $("#Email").setValue(mail);
        $("#Password").setValue(password);
        $("#ConfirmPassword").setValue(password);
        $(byValue("Зарегистрироваться")).click();
        return page(RegistrationPage.class);
    }

    public SelenideElement notAcceptedAgreementMessage() {
        return $(byText("Согласитесь с правилами, чтобы продолжить"));
    }
    
}
