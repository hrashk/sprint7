package praktikum.courier;

import io.restassured.response.ValidatableResponse;
import praktikum.Client;

import java.util.Map;

public class CourierClient extends Client {

    private static final String COURIER = "courier";

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

    public ValidatableResponse delete(int id) {
        return spec()
                .body(Map.of("id", id))
                .when()
                .post(COURIER + "/" + id)
                .then().log().all();
    }
}
