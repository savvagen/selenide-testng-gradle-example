package com.example;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.net.MalformedURLException;
import static com.codeborne.selenide.Configuration.*;


public class TestBase {



    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        SelenideLogger.addListener("allureSelenide", new AllureSelenide());
        browser = WebDriverRunner.CHROME;
        startMaximized = false;
    }


    @AfterClass(alwaysRun = true)
    public void tearDownClass(){
        SelenideLogger.removeListener("allureSelenide");
    }



}
