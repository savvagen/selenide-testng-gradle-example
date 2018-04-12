package com.example;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.Rule;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.containers.RecordingFileFactory;

import java.io.File;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.*;

public class DemoJunit {



    @Rule
    public BrowserWebDriverContainer chrome = new BrowserWebDriverContainer()
            .withDesiredCapabilities(DesiredCapabilities.chrome())
            .withRecordingMode(RECORD_ALL, new File("out"));



    @org.junit.Test
    public void searchTest()  {
        WebDriverRunner.setWebDriver(chrome.getWebDriver());
        open("https://google.com");
        $(byName("q")).val("Selenium Webdriver").pressEnter();
        $$(".srg .g").forEach(element -> element.is(disabled));
        $$(".srg .g").first().$("h3 > a").shouldHave(text("Selenium WebDriver"));
    }



}
