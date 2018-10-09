package com.socks.tests.brutal;

import com.socks.api.model.Address;
import com.socks.api.services.AddressesApiService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.socks.api.conditions.Conditions.body;
import static com.socks.api.conditions.Conditions.statusCode;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsEqual.equalTo;

public class AddressTests {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://178.128.204.170/";
    }

    private AddressesApiService addressesApiService = new AddressesApiService();

    @Test
    void testCanCreateNewAddress() {
        //given
        Address address = new Address()
                .setStreet("Rabochaya")
                .setNumber("21")
                .setCountry("Russia")
                .setCity("Gorod Zero")
                .setPostcode("102030")
                .setUserID("5ba41886ee11cb00014c9b76");

        // expect
        addressesApiService.createAddress(address)
                .shouldHave(statusCode(200))
                .shouldHave(body("status_code", not(equalTo(500))));
                 //.shouldHave(body("id", not(isEmptyString()))
    }

    @Test
    void testCanGetUserAddress() {
        //expect
        addressesApiService.getAddress("5bae124fee11cb00014c9b8c")
                .shouldHave(statusCode(200))
                .shouldHave(body("street", not(isEmptyString())));
    }
}
