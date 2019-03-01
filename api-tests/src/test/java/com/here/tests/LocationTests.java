package com.here.tests;

import com.here.api.services.LocationApiService;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.here.api.conditions.Conditions.body;
import static com.here.api.conditions.Conditions.statusCode;
import static org.hamcrest.CoreMatchers.hasItem;

public class LocationTests {

    @BeforeSuite
    static void setUp() {
        RestAssured.baseURI = "https://geocoder.api.here.com";
    }

    LocationApiService locationApiService = new LocationApiService();

    @Test
    void testCanGetLocationBySearchText() {

        locationApiService.getLocation("Schönblickstraße 47 71272 Renningen")
                .shouldHave(statusCode(200))
                .shouldHave(body("Response.View.Result.Location.Address.Country[0]", hasItem("DEU")))
                .shouldHave(body("Response.View.Result.Location.Address.City[0]", hasItem("Renningen")));
        }
}
