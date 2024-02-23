import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaStepsTest extends TestBase {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUENAME = "Listeners NamedBy";

    @Test
    @Feature("Issue в репозитории")
    @Story("Поиск Issue по названию")
    @Owner("Elena Belavina")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Issues", url = "https://github.com/eroshenkoam/allure-example/issues")
    @DisplayName("Тест на поиск Issue по названию (лямбда-шаги)")

    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $("[data-target='qbsearch-input.inputButtonText']").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").pressEnter();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с названием" + ISSUENAME, () -> {
            $("#issue_68_link").shouldHave(text(ISSUENAME));
        });
    }
}
