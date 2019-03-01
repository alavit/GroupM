package com.mplatform.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PrivacyPolicyPage {

    public ElementsCollection privacyPolicyLinks = $$(byXpath("//td//a[contains(@href,'https')]"));
    public SelenideElement dismissCookiesButton = $(byXpath("//a[@class='cc-btn cc-dismiss']"));

    public PrivacyPolicyPage dismissCookies() {
        dismissCookiesButton.click();

        return new PrivacyPolicyPage();
    }

    public void clickLink(SelenideElement link) {
        link.click();
    }
}
