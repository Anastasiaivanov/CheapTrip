package com.telran.cheaptrip.tests;

import com.telran.cheaptrip.pages.MainPageHelper;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTests extends TestBase {

    MainPageHelper mainPage;

    @BeforeMethod
    public void initTest() {
        mainPage = PageFactory.initElements(driver, MainPageHelper.class);
    }

    @Test(priority = 2, groups = {"UI"})
    public void sloganValidationTest() {
        String text = "CheapTrip. Pay less, travel more";
        assert mainPage.isSloganContainsText(text);
    }

    @Test(priority = 1, groups = {"Functional"})
    public void changeLanguageValidationTest() throws InterruptedException {
        mainPage.selectRussianLanguage();
        Thread.sleep(100);
        assert mainPage.isLanguageOnPageRussian("Найдите самый дешевый способ добраться из города в город, сочетая самолет, поезд, автобус и совместные поездки на автомобиле");
    }

    @Test
    public void searchRoute() {
        mainPage.findRoute("Berlin", "Moscow");
    }

    @Test
    public void start() {
        System.out.println("site opened");
    }

    @Test(priority = 1, groups = {"Functional"})
    public void searchContactsTest() {
        mainPage.findContacts();
        mainPage.takeScreenshot();
        assert mainPage.isContactsIsVisible("Contacts");
    }

    @Test
    public void changeCurrencyTest() {
        mainPage.changeCurrency();
        //assert mainPage.isNeededCurrencyIsPresent("USD");
    }


}
