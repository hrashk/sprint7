package praktikum;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import praktikum.courier.Courier;
import praktikum.courier.CourierClient;
import praktikum.courier.Credentials;

public class CourierTest {
    private CourierClient client = new CourierClient();
    private int courierId;

    @AfterEach
    void dropCourier() {
        if (courierId != 0) {
            client.deleteCourier(courierId);
        }
    }

    @Test
    @DisplayName("Создание курьера")
    public void courier() {
        var courier = Courier.random();
        ValidatableResponse createResponse = client.createCourier(courier);
        client.createSuccessful(createResponse);

        var creds = Credentials.fromCourier(courier);
        ValidatableResponse logInResponse = client.logIn(creds);
        courierId = client.loginSuccessful(logInResponse);
    }
}
