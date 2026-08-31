package praktikum.courier;

import io.restassured.response.ValidatableResponse;
import praktikum.Client;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourierClient extends Client {
    static final String COURIER = "courier";

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

    public void createSuccessful(ValidatableResponse createResponse) {
        boolean created = createResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_CREATED)
                .extract()
                .path("ok")
        ;
        assertTrue(created);
    }

    public ValidatableResponse logIn(Credentials creds) {
        return spec()
                .body(creds)
                .when()
                .post(COURIER + "/login")
                .then().log().all();
    }

    public ValidatableResponse createCourier(Courier courier) {
        return spec()
                .body(courier)
                .when()
                .post(COURIER)
                .then().log().all();
    }

    public ValidatableResponse deleteCourier(int id) {
        return null;
    }
}
