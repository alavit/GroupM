package com.here.api.conditions;

public class Conditions {

    public static StatusCodeCondition statusCode(int code) {
        return new StatusCodeCondition(code);
    }

    public static BodyCondition body(String path, org.hamcrest.Matcher matcher) {
        return new BodyCondition(path, matcher);
    }
}
