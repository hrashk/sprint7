package praktikum.courier;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourierChecker {
    @Step("логин успешный")
    public Integer loggedInSuccessfully(ValidatableResponse loginResponse) {
        int id= loginResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .extract()
                .path("id");

        assertNotEquals(0, id);

        return id;
    }

    @Step("курьера удалось создать")
    public void createdSuccessfully(ValidatableResponse createResponse) {
        boolean created = createResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_CREATED)
                .extract()
                .path("ok")
        ;
        assertTrue(created);
    }
}
