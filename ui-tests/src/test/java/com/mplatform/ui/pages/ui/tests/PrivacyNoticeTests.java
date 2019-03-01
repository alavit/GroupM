package com.mplatform.ui.pages.ui.tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.mplatform.ui.pages.PrivacyPolicyPage;
import com.mplatform.ui.pages.RegistryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.url;

public class PrivacyNoticeTests extends BaseTest {

    @Test
    public void testCanGoToPrivacyNoticeAndClickAllLinks() {

        PrivacyPolicyPage privacyPolicyPage = RegistryPage.open()
                                                .openPrivacyPolicy();

        ElementsCollection links = privacyPolicyPage.privacyPolicyLinks;

        for (SelenideElement link:links) {
            String URLInLink = link.getAttribute("href");
            privacyPolicyPage.dismissCookies();
            privacyPolicyPage.clickLink(link);
            Assert.assertEquals(url(), URLInLink);
        }
    }
}
