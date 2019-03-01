package com.here.api.services;

import com.here.api.AssertableResponse;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocationApiService {

    public RequestSpecification setup(){
        return RestAssured.given()
                .contentType(ContentType.TEXT)
                .filters(new RequestLoggingFilter(),
                        new ResponseLoggingFilter());
    }

    @Step
    public AssertableResponse getLocation(String searchText) {
        log.info("Get location by searchText", searchText);

        return new AssertableResponse(setup()
                .given()
                .queryParam("app_id", "z9tFDol7mClkMlk1l1F5")
                .queryParam("app_code", "lee5ciPJBqOatO8Jd6WUZA")
                .queryParam("searchText", searchText)
                .when()
                .get("/6.2/geocode.json")
                .then()
                .using().parser("text/plain", Parser.JSON));
    }
}
