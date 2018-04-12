package com.example;


import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;



@Listeners(ScreenShooter.class)
public class DemoTest extends TestContBase {


    @Test
    public void searchTest()  {
        open("https://google.com");
        $(byName("q")).val("Selenium Webdriver").pressEnter();
        $$(".srg .g").forEach(element -> element.is(disabled));
        $$(".srg .g").first().$("h3 > a").shouldHave(text("Selenium WebDriver"));
    }

    @Test
    public void searchTest1()  {
        open("https://google.com");
        $(byName("q")).val("Selenium Webdriver").pressEnter();
        $$(".srg .g").forEach(element -> element.is(disabled));
        $$(".srg .g").first().$("h3 > a").shouldHave(text("Selenium WebDriver"));
    }

    @Test
    public void searchTest2() {
        open("https://google.com");
        $(byName("q")).val("Selenium Webdriver").pressEnter();
        $$(".srg .g").forEach(element -> element.is(disabled));
        $$(".srg .g").first().$("h3 > a").shouldHave(text("Selenium WebDriver"));
    }


    @Test
    public void searchTest3() {
        open("https://google.com");
        $(byName("q")).val("Selenium Webdriver").pressEnter();
        $$(".srg .g").forEach(element -> element.is(disabled));
        $$(".srg .g").first().$("h3 > a").shouldHave(text("Selenium WebDriver"));
    }





}
