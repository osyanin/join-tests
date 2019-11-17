package core.utils.reg;

import com.codeborne.selenide.SelenideElement;
import core.TestBase;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationSuccessPage extends TestBase {
    public SelenideElement registrationSuccessCaption() {
        return $(byText("Регистрация успешна"));
    }
}
