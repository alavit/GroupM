package com.socks.tests.brutal;

import com.github.javafaker.Faker;
import com.socks.api.model.User;
import com.socks.api.services.UserApiService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.socks.api.conditions.Conditions.body;
import static com.socks.api.conditions.Conditions.statusCode;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

public class UserManagerTests {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://178.128.204.170/";
    }

    private Faker faker = new Faker(new Locale("ru"));
    private UserApiService userApiService = new UserApiService();

    @Test
    void testCanRegisterAsValidUser() {
        //given
        User user = new User()
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setUsername(faker.name().username())
                .setEmail(faker.internet().emailAddress())
                .setPassword(faker.internet().password()) ;

        // expect
        userApiService.registerUser(user)
                .shouldHave(statusCode(200))
                .shouldHave(body("id", not(isEmptyString())));
    }

    @Test
    void testCanNotRegisterAsInvalidUser() {
        // given
        User user = new User()
                .setFirstName("")
                .setLastName("")
                .setUsername("")
                .setEmail("")
                .setPassword("");
        // expect
       userApiService.registerUser(user)
               .shouldHave(statusCode(500));
    }
}
