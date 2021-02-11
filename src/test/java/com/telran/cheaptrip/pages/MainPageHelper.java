package com.telran.cheaptrip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(css = "input[name='ion-input-0']")
    WebElement fromWhere;

    @FindBy(css = "input[name='ion-input-1']")
    WebElement toWhere;

    @FindBy(css = ".ion-color.ion-color-primary.md.button.button-small.button-solid.ion-activatable.ion-focusable.hydrated")
    WebElement letsGoButton;

    @FindBy(css = ".md.button.in-toolbar.in-toolbar-color.ion-activatable.ion-focusable.hydrated")
    WebElement hamburger;

    @FindBy(xpath = "//*[contains(text(),'Contacts')]")
    WebElement contacts;

    @FindBy(css = ".autocomplete.item.md.ion-focusable.hydrated")
    List<WebElement> choiceFromList;

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
        choiceFromList.get(0).click();
        inputTextToField(toWhere, toCity);
        choiceFromList.get(0).click();
        letsGoButton.click();
    }

    public void findContacts() {
        hamburger.click();
        waitUntilElementVisible(contacts,3);
        contacts.click();
    }

    public boolean isContactsIsVisible(String text) {
        return contacts.getText().contains(text);
    }
}
