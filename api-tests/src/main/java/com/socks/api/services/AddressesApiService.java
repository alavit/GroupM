package com.socks.api.services;

import com.socks.api.AssertableResponse;
import com.socks.api.model.Address;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AddressesApiService {

    public RequestSpecification setup(){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .filters(new RequestLoggingFilter(),
                        new ResponseLoggingFilter());
    }

    @Step
    public AssertableResponse createAddress(Address address) {
        log.info("Create address", address);

        return new AssertableResponse(setup()
                .body(address)
                .when()
                .post("addresses")
                .then()
                .using().parser("text/plain", Parser.JSON));
    }

    @Step
    public AssertableResponse getAddress (String userId) {
        log.info("Get address for userId", userId);

        return new AssertableResponse(setup()
                .body(userId)
                .when()
                .get("addresses/" + userId)
                .then()
                .using().parser("text/plain", Parser.JSON));
    }
}
