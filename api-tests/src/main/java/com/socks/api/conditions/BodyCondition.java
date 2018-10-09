package com.socks.api.conditions;

import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matcher;

public class BodyCondition implements Condition {

    private String path;
    private Matcher matcher;

    public BodyCondition(String path, Matcher matcher) {
        this.path = path;
        this.matcher = matcher;
    }

    @Override
    public void check(ValidatableResponse response) {
        response.assertThat().body(path, matcher);
    }

    @Override
    public String toString() {
        return "path " + "'" + path + "'" + " is " + matcher;
    }
}
