package praktikum.courier;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class CourierTest {
    private CourierClient client = new CourierClient();
    private CourierChecks check = new CourierChecks();

    @Test
    public void courier() {
        var courier = Courier.random();
        ValidatableResponse createResponse = client.createCourier(courier);
        check.checkCreated(createResponse);

        var creds = CourierCredentials.fromCourier(courier);
        ValidatableResponse loginResponse = client.logIn(creds);
        int id = check.checkLoggedIn(loginResponse);
    }
}
