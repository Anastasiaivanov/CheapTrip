package com.telran.cheaptrip.tests;

import com.telran.cheaptrip.pages.MainPageHelper;
import com.telran.cheaptrip.util.DataProviders;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTests extends TestBase {

    MainPageHelper mainPage;
    String cityFrom = "Berlin";
    String cityTo = "Moscow";

    @BeforeMethod
    public void initTest() {
        mainPage = PageFactory.initElements(driver, MainPageHelper.class);
    }

    @Test()
    public void searchResultPresent() {
        mainPage.inputCityFromField(cityFrom);
        mainPage.inputCityToField(cityTo);
        mainPage.clickOnLetsGoButton();
        Assert.assertTrue(mainPage.searchResultIsDisplayed(),
                "Search result for cities: " + cityFrom + cityTo + " isn't displayed");
    }

    @Test(dataProvider = "routeToSearch", dataProviderClass = DataProviders.class)
    public void searchResultPresentDataProvider(String cityFrom, String cityTo) {
        mainPage.inputCityFromField(cityFrom);
        mainPage.inputCityToField(cityTo);
        mainPage.clickOnLetsGoButton();

        Assert.assertTrue(mainPage.searchResultIsDisplayed(),
                "Search result for cities: " + cityFrom + cityTo + " isn't displayed");
    }
}
