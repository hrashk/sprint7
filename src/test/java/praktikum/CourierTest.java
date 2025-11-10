package praktikum;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import praktikum.courier.Courier;
import praktikum.courier.CourierClient;
import praktikum.courier.Creds;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CourierTest {
    CourierClient client = new CourierClient();
    int courierId;

    @AfterEach
    public void dropCourier() {
        if (courierId > 0) {
            client.delete(courierId);
            // todo client.checkDeleted(deleteResponse)
        }
    }

    @Test
    @DisplayName("удачливый курьер")
    public void courier() {
        var courier = Courier.random();
        ValidatableResponse createResponse = client.create(courier);
        client.checkCreated(createResponse);

        var creds = Creds.fromCourier(courier);
        ValidatableResponse loginResponse = client.logIn(creds);
        courierId = client.checkLoggedIn(loginResponse);

        assertNotEquals(0, courierId);
    }
}
