package org.traineProject.utils.callbacks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.traineProject.utils.config.ConfigData;


import static com.codeborne.selenide.Selenide.open;


public class SelenideExtension implements BeforeAllCallback, BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        Configuration.browser = ConfigData.BROWSER.getValue();
        Configuration.browserSize = ConfigData.BROWSER_SIZE.getValue();
        Configuration.headless = Boolean.parseBoolean(ConfigData.BROWSER_HEADLESS.getValue());

        // базовый URL
        Configuration.baseUrl = ConfigData.BASE_URL.toString();
        // стратегия загрузки страницы
        Configuration.pageLoadStrategy = "eager";

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        open("");
        // развернуть браузер на весь экран (ВСЕГДА после open!!!)
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        // если драйвер запущен, почистить BrowserCache, Cookies, LocalStorage
        if (WebDriverRunner.hasWebDriverStarted()) {
            WebDriverRunner.clearBrowserCache();
            Selenide.clearBrowserCookies();
            Selenide.clearBrowserLocalStorage();
        }
    }
}
