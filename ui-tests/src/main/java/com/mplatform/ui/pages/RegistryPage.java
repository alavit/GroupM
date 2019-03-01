package com.mplatform.ui.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class RegistryPage {

    public SelenideElement privacyPolicyLink = $(byXpath("//a[text()='GroupM Privacy Policy']"));

    public static RegistryPage open() {
        return Selenide.open("/", RegistryPage.class);
    }

    public PrivacyPolicyPage openPrivacyPolicy() {
        privacyPolicyLink.click();

        return new PrivacyPolicyPage();
    }
}
