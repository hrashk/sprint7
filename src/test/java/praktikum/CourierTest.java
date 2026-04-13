package praktikum;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import praktikum.courier.Courier;
import praktikum.courier.CourierChecker;
import praktikum.courier.CourierClient;

public class CourierTest {
    private final CourierClient client = new CourierClient();
    private final CourierChecker check = new CourierChecker();

    private int courierId;

    @AfterEach
    public void dropCourier() {
        if (courierId != 0) {
            client.deleteCourier(courierId);
        }
    }

    @DisplayName("успешное создание курьера")
    @Test
    public void courier() {
        var courier = Courier.random();
        ValidatableResponse createResponse = client.create(courier);
        check.createdSuccessfully(createResponse);

        var creds  = Credentials.fromCourier(courier);
        ValidatableResponse loginResponse = client.logIn(creds);
        courierId = check.loggedInSuccessfully(loginResponse);
    }
}
