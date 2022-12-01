package org.example.courier;


import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.example.Client;

public class CourierClient extends Client {

    public static final String ROOT = "/courier";

    @Step("Создать курьера")
    public ValidatableResponse create(Courier courier) {
        return spec()
                .body(courier)
                .when()
                .post(ROOT)
                .then().log().all();
    }

    @Step("Залогиниться")
    public ValidatableResponse logIn(Credentials creds) {
        return spec()
                .body(creds)
                .when()
                .post(ROOT + "/login")
                .then().log().all();
    }

    @Step("Удалить курьера")
    public void delete(int courierId) {

    }
}
