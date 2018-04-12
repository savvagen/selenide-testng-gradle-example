package com.example;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.File;
import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL;

public class TestContBase {

    public BrowserWebDriverContainer chrome;


    @BeforeClass
    public void setUpClass() {
        SelenideLogger.addListener("allureSelenide", new AllureSelenide());

        chrome = new BrowserWebDriverContainer().withDesiredCapabilities(DesiredCapabilities.chrome())
                .withRecordingMode(RECORD_ALL, new File("out"));

        chrome.start();
        WebDriverRunner.setWebDriver(chrome.getWebDriver());

    }


    @AfterClass
    public void tearDownClass(){
        SelenideLogger.removeListener("allureSelenide");
        chrome.stop();
    }


}
