package org.example.courier;

import io.restassured.response.ValidatableResponse;

import java.util.Map;

public class CourierClient extends org.example.Client {
    static final String COURIER_PATH = "/courier";

    public CourierClient(String baseUri) {
        super(baseUri);
    }

    public ValidatableResponse create(Courier courier) {
        return spec()
                .body(courier)
                .when()
                .post(COURIER_PATH)
                .then();
    }

    public ValidatableResponse login(Credentials creds) {
        return spec()
                .body(creds)
                .when()
                .post(COURIER_PATH + "/login")
                .then();
    }

    public ValidatableResponse delete(int courierId) {
        return spec()
                .body(Map.of("id", String.valueOf(courierId)))
                .when()
                .delete(COURIER_PATH + "/" + courierId)
                .then();
    }
}
