package org.example.courier;


import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.example.Client;

import static org.hamcrest.Matchers.*;

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

    @Step("Курьер успешно создан")
    public void assertCreatedSuccessfully(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(201)
                .and()
                .body("ok", is(true));
    }

    @Step("Курьер не получился")
    public String assertCreationFailed(ValidatableResponse response, int expectedStatusCode) {
        return response
                .assertThat()
                .statusCode(expectedStatusCode)
                .and()
                .body("message", not(blankOrNullString()))
                .extract()
                .path("message");
    }

    @Step("Залогиниться")
    public ValidatableResponse logIn(Credentials creds) {
        return spec()
                .body(creds)
                .when()
                .post(ROOT + "/login")
                .then().log().all();
    }

    @Step("Логин был успешным")
    public int assertLoggedInSuccessfully(ValidatableResponse loginResponse) {
        return loginResponse
                .assertThat()
                .statusCode(200)
                .and()
                .body("id", greaterThan(0))
                .extract()
                .path("id");
    }

    @Step("Удалить курьера")
    public void delete(int courierId) {

    }
}
