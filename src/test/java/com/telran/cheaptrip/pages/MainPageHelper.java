package com.telran.cheaptrip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageHelper extends PageBase {

    public MainPageHelper(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".hide-xs.md.title-default.hydrated")
    WebElement slogan;

    @FindBy(css = "ion-buttons.select.buttons-last-slot.sc-ion-buttons-md-h.sc-ion-buttons-md-s.md.hydrated")
    WebElement selectLang;

    @FindBy(id = "ion-rb-38-lbl")
    WebElement englishLang;

    @FindBy(tagName = "ion-card-title")
    WebElement title;

    public boolean isSloganContainsText(String text) {
        return slogan.getText().contains(text);
    }

    public void selectEnglishLanguage() {
        selectLang.click();
        waitUntilElementVisible(englishLang,20);
    }

    public boolean isLanguageOnPageEnglish(String text) {
        return title.getText().contains(text);
    }
}
