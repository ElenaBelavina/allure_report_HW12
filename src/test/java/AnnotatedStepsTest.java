import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest extends TestBase {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final  String ISSUENAME = "Listeners NamedBy";

    @Test
    @Feature("Issue в репозитории")
    @Story("Поиск Issue по названию")
    @Owner("Elena Belavina")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Issues", url = "https://github.com/eroshenkoam/allure-example/issues")
    @DisplayName("Тест на поиск Issue по названию (шаги с аннотацией @Step)")
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Steps steps = new Steps();

        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.issueNameCheck(ISSUENAME);
    }
}
