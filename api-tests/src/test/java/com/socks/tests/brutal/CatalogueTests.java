package com.socks.tests.brutal;

import com.socks.api.services.CatalogueApiService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.socks.api.conditions.Conditions.body;
import static com.socks.api.conditions.Conditions.statusCode;
import static org.hamcrest.core.IsEqual.equalTo;

public class CatalogueTests {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://178.128.204.170/";
    }

    CatalogueApiService catalogueApiService = new CatalogueApiService();

    @Test
    void testCanGetProductById() {
        //expect
        catalogueApiService.getProduct("zzz4f044-b040-410d-8ead-4de0446aec7e")
                .shouldHave(statusCode(200))
                .shouldHave(body("name", equalTo("Classic")))
                .shouldHave(body("description", equalTo("Keep it simple.")));
    }
}
