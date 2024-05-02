package org.example.courier;

import io.restassured.response.ValidatableResponse;
import org.example.Client;

import java.util.Map;

public class CourierClient extends Client {
    private static final String COURIER_PATH = "/courier";

    public ValidatableResponse loginCourier(CourierCredentials creds) {
        return spec()
                .body(creds)
                .when()
                .post(COURIER_PATH + "/login")
                .then().log().all();
    }

    public ValidatableResponse createCourier(Courier courier) {
        return spec()
                .body(courier)
                .when()
                .post(COURIER_PATH)
                .then().log().all();
    }

    public ValidatableResponse deleteCourier(int id) {
        return spec()
                .body(Map.of("id", id))
                .when()
                .delete(COURIER_PATH + "/" + id)
                .then().log().all();
    }
}
