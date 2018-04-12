package com.example;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class SelenoidBase {


    public DesiredCapabilities dc;

    @BeforeClass(alwaysRun = true)
    @Parameters({"browserType", "browserVersion"})
    public void setUpClass(String browserType, String browserVersion) throws MalformedURLException {
        SelenideLogger.addListener("allureSelenide", new AllureSelenide());
        //browser = WebDriverRunner.CHROME;
        //startMaximized = false;

        URL remoteUrl = new URL("http://test:test-password@localhost:4444/wd/hub");
        switch (browserType){
            case "chrome":
                dc = DesiredCapabilities.chrome();
            case "firefox":
                dc = DesiredCapabilities.firefox();
        }
        dc.setBrowserName(browserType);
        dc.setVersion(browserVersion);
        dc.setCapability("enableVNC", true);
        dc.setCapability("enableVideo", true);
        dc.setCapability("screenResolution", "1960x1280x24");
        dc.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
        dc.setCapability("videoName", "selenoid_recording.mp4");
        dc.setCapability("videoScreenSize", "1960x1280");
        dc.setPlatform(Platform.LINUX);
        dc.setJavascriptEnabled(true);
        RemoteWebDriver selenoidDriver = new RemoteWebDriver(remoteUrl, dc);
        setWebDriver(selenoidDriver);
        getWebDriver().manage().window().setSize(new Dimension(1920, 1080));
    }


    @AfterClass(alwaysRun = true)
    public void tearDownClass(){
        SelenideLogger.removeListener("allureSelenide");
    }




}
