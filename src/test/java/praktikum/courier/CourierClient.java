package praktikum.courier;

import io.restassured.response.ValidatableResponse;
import praktikum.Client;

import java.util.Map;

public class CourierClient extends Client {

    public ValidatableResponse logIn(Credentials creds) {
        return spec()
                .body(creds)
                .when()
                .post("/courier/login")
                .then().log().all();
    }

    public ValidatableResponse createCourier(Courier courier) {
        return spec()
                .body(courier)
                .when()
                .post("/courier")
                .then().log().all();
    }

    public ValidatableResponse delete(int id) {
        return spec()
                .body(Map.of("id", id))
                .when()
                .delete("/courier/" + id)
                .then().log().all();
    }
}
