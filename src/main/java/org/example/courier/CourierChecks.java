package org.example.courier;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.*;

public class CourierChecks {
    @Step("Курьер успешно создан")
    public void createdSuccessfully(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(201)
                .and()
                .body("ok", is(true));
    }

    @Step("Курьер не получился")
    public String creationFailed(ValidatableResponse response, int expectedStatusCode) {
        return response
                .assertThat()
                .statusCode(expectedStatusCode)
                .and()
                .body("message", not(blankOrNullString()))
                .extract()
                .path("message");
    }

    @Step("Логин был успешным")
    public int loggedInSuccessfully(ValidatableResponse loginResponse) {
        return loginResponse
                .assertThat()
                .statusCode(200)
                .and()
                .body("id", greaterThan(0))
                .extract()
                .path("id");
    }
}
