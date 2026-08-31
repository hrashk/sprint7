package praktikum.courier;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import praktikum.Client;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourierClient extends Client {
    static final String COURIER = "courier";

    @Step("логин успешный")
    public int loginSuccessful(ValidatableResponse logInResponse) {
        int id = logInResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .extract()
                .path("id")
                ;


        assertNotEquals(0, id);
        return id;
    }

    @Step("курьер создан")
    public void createSuccessful(ValidatableResponse createResponse) {
        boolean created = createResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_CREATED)
                .extract()
                .path("ok")
        ;
        assertTrue(created);
    }

    @Step("логин")
    public ValidatableResponse logIn(Credentials creds) {
        return spec()
                .body(creds)
                .when()
                .post(COURIER + "/login")
                .then().log().all();
    }

    @Step("Создание курьера")
    public ValidatableResponse createCourier(Courier courier) {
        return spec()
                .body(courier)
                .when()
                .post(COURIER)
                .then().log().all();
    }

    @Step("удалить курьера")
    public ValidatableResponse deleteCourier(int id) {
        return null;
    }
}
