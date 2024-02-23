import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends TestBase {
    @Test
    @Feature("Issue в репозитории")
    @Story("Поиск Issue по названию")
    @Owner("Elena Belavina")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Issues", url = "https://github.com/eroshenkoam/allure-example/issues")
    @DisplayName("Тест на поиск Issue по названию (чистый селенид)")

    public void issueNameSearchTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").sendKeys("eroshenkoam/allure-example");
        $("#query-builder-test").pressEnter();

        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $("#issue_68_link").shouldHave(text("Listeners NamedBy"));
    }
}
