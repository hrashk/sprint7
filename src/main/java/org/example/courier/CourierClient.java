package org.example.courier;

import io.restassured.response.ValidatableResponse;

import java.util.Map;

public class CourierClient extends org.example.Client {
    static final String COURIER_PATH = "/courier";

    public ValidatableResponse create(Courier courier) {
        return spec()
                .body(courier)
                .when()
                .post(COURIER_PATH)
                .then().log().all();
    }

    public ValidatableResponse login(Credentials creds) {
        return spec()
                .body(creds)
                .when()
                .post(COURIER_PATH + "/login")
                .then().log().all();
    }

    public ValidatableResponse delete(int courierId) {
        return spec()
                .body(Map.of("id", String.valueOf(courierId)))
                .when()
                .delete(COURIER_PATH + "/" + courierId)
                .then().log().all();
    }
}
