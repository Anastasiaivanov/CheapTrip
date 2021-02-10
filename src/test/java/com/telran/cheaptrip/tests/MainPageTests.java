package com.telran.cheaptrip.tests;

import com.telran.cheaptrip.pages.MainPageHelper;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTests extends TestBase{

    MainPageHelper mainPage;

    @BeforeMethod
    public void initTest(){
        mainPage= PageFactory.initElements(driver,MainPageHelper.class);
    }

    @Test(priority = 2, groups = {"UI"})
    public void sloganValidationTest(){
        String text = "CheapTrip.  Плати меньше, посети больше!";
        assert mainPage.isSloganContainsText(text);
    }

    @Test(priority = 1, groups = {"Functional"})
    public void changeLanguageValidationTest(){
        mainPage.selectEnglishLanguage();
        assert mainPage.isLanguageOnPageEnglish("Discover the cheapest way  to get anywhere combining plane, train, bus and rideshare ");
    }

    @Test
    public void start(){
        System.out.println("site opened");
    }
}
