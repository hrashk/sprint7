package org.example.courier;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.example.Client;

public class CourierClient extends Client {
    static final String COURIER_API = "/courier";

    @Step
    public ValidatableResponse createCourier(Courier courier) {
        return spec()
                .body(courier)
                .when()
                .post(COURIER_API)   // CREATE
                .then().log().all();
    }

    public ValidatableResponse logIn(Credentials creds) {
        return spec()
                .body(creds)
                .when()
                .post(COURIER_API + "/login")  // LOG IN
                .then().log().all();
    }
}
