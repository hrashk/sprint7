package praktikum.courier;

import io.restassured.response.ValidatableResponse;
import praktikum.Client;

import java.net.HttpURLConnection;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourierClient extends Client {
    public Integer checkLoggedIn(ValidatableResponse loginResponse) {
        return loginResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .extract()
                .path("id");
    }

    public void checkCreated(ValidatableResponse createResponse) {
        boolean created = createResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_CREATED)
                .extract()
                .path("ok");
        assertTrue(created);
    }

    public ValidatableResponse logIn(Creds creds) {
        return spec()
                .body(creds)
                .when()
                .post("/courier/login")
                .then().log().all();
    }

    public ValidatableResponse create(Courier courier) {
        return spec()
                .body(courier)
                .when()
                .post("/courier")
                .then().log().all();
    }

    public ValidatableResponse delete(int courierId) {
        return spec()
                .body(Map.of("id", courierId))
                .when()
                .delete("/courier/" + courierId)
                .then().log().all();
    }
}
