package tests.ui;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.traineProject.utils.callbacks.SelenideExtension;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@ExtendWith(SelenideExtension.class)
public class GoogleSearchTest {
    @Test
    void googleSearchShouldWork() {
        $("[name='q']").setValue("Selenide").pressEnter();
        $("#search").shouldHave(text("selenide.org"));
    }
}
