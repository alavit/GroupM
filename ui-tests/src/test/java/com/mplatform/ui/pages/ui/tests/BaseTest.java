package com.mplatform.ui.pages.ui.tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1366x768";
        Configuration.baseUrl = "https://registry.mplatform.com/#about";
    }
}
