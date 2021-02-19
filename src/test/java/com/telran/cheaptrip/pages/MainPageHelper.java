package com.telran.cheaptrip.pages;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainPageHelper extends PageBase {

    public MainPageHelper(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".hide-xs.md.title-default.hydrated")
    WebElement slogan;

    @FindBy(css = "ion-buttons.select.buttons-last-slot.sc-ion-buttons-md-h.sc-ion-buttons-md-s.md.hydrated")
    WebElement selectLang;

    @FindBy(css = "ion-item.select-interface-option")
    List<WebElement> langList;

    @FindBy(id = "ion-rb-38-lbl")
    WebElement russianLang;

    @FindBy(tagName = "ion-card-title")
    WebElement title;

    @FindBy(name = "ion-input-0")
    WebElement fromWhere;

    @FindBy(name = "ion-input-1")
    WebElement toWhere;

    @FindBy(css = "ion-button.ion-color-primary")
    WebElement letsGoButton;

    @FindBy(css = ".md.button.in-toolbar.in-toolbar-color.ion-activatable.ion-focusable.hydrated")
    WebElement hamburger;

    @FindBy(xpath = "//*[contains(text(),'Contacts')]")
    WebElement contacts;

    @FindBy(xpath = "//ion-item//ion-label[@id='ion-input-0-lbl']//..//..//ion-item//ion-list")
    WebElement submitCityFrom;

    @FindBy(xpath = "//ion-item//ion-label[@id='ion-input-1-lbl']//..//..//ion-item//ion-list")
    WebElement submitCityTo;

    @FindBy(css = ".city")
    List<WebElement> resultsList;

    @FindBy(css = ".select.buttons-first-slot.sc-ion-buttons-md-h.sc-ion-buttons-md-s.md.hydrated")
    WebElement currencyButton;

    @FindBy(css = ".popover-content.sc-ion-popover-md")
    List<WebElement> currencyList;

    @FindBy(css = ".sc-ion-select-popover.md.in-item.interactive.radio-checked.hydrated")
    WebElement currencyUsd;

    public boolean isSloganContainsText(String text) {
        return slogan.getText().contains(text);
    }

    public void selectRussianLanguage() {
        selectLang.click();
        waitUntilElementVisible(russianLang, 3);
        langList.get(1).click();
    }

    public boolean isLanguageOnPageRussian(String text) {
        return title.getText().contains(text);
    }

    public void findRoute(String fromCity, String toCity) {
        inputTextToField(fromWhere, fromCity);
        submitCityFrom.click();
        inputTextToField(toWhere, toCity);
        submitCityTo.click();
        letsGoButton.click();
    }

    public void findContacts() {
        hamburger.click();
        waitUntilElementVisible(contacts, 3);
        contacts.click();
    }

    public boolean isContactsIsVisible(String text) {
        return contacts.getText().contains(text);
    }

    public boolean isNeededCurrencyIsPresent(String text){
        return currencyButton.getText().contains(text);
    }

    public void inputCityFromField(String cityFrom) {
        inputTextToField(fromWhere, cityFrom);
        waitUntilElementVisible(submitCityFrom, 5);
        submitCityFrom.click();
    }

    public void inputCityToField(String cityTo) {
        inputTextToField(toWhere, cityTo);
        waitUntilElementVisible(submitCityTo, 5);
        submitCityTo.click();
    }

    public void clickOnLetsGoButton() {
        letsGoButton.click();
    }

    public boolean searchResultIsDisplayed() {
        return resultsList.size() > 0;
    }

    public void changeCurrency() {
        currencyButton.click();
        waitUntilElementVisible(currencyUsd,5);
        currencyList.get(1).click();
    }

    public String takeScreenshot() {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshot" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot.getAbsolutePath();
    }
}
