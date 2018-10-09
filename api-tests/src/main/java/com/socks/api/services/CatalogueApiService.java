package com.socks.api.services;

import com.socks.api.AssertableResponse;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CatalogueApiService {

    public RequestSpecification setup(){
        return RestAssured.given()
                .contentType(ContentType.TEXT)
                .filters(new RequestLoggingFilter(),
                        new ResponseLoggingFilter());

    }

    @Step
    public AssertableResponse getProduct (String productId) {
        log.info("Get product by productId", productId);

        return new AssertableResponse(setup()
                .body(productId)
                .when()
                .get("/catalogue/" + productId)
                .then()
                .using().parser("text/plain", Parser.JSON));
    }
}
