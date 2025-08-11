package praktikum.courier;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CourierTest {
    final CourierClient client = new CourierClient();
    final CourierChecks check = new CourierChecks();

    int courierId;

    @AfterEach
    public void deleteCourier() {
        if (courierId > 0) {
            client.delete(courierId);
        }
    }

    @Test
    @DisplayName("удачливый курьер")
    public void courier() {
        var courier = Courier.random();

        ValidatableResponse createResponse = client.createCourier(courier);
        check.created(createResponse);

        var creds = Credentials.from(courier);

        ValidatableResponse loginResponse = client.logIn(creds);
        courierId = check.loggedIn(loginResponse);

        assertNotEquals(0, courierId);
    }
}
