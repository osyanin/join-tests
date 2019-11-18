package core.utils.project;

import com.codeborne.selenide.SelenideElement;
import core.TestBase;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainProjectPage extends TestBase {

    public SelenideElement projectActiveCaption() {
        return $(byText("Проект активен"));
    }

    public SelenideElement claimsAcceptingIsClosedCaption() {
        return $(byText("Прием заявок закрыт"));
    }
}
