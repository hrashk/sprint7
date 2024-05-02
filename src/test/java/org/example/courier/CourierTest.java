package org.example.courier;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class CourierTest {

    private final CourierClient client = new CourierClient();
    private final CourierChecks check = new CourierChecks();

    @Test
    public void courier() {
        var courier = Courier.random();
        ValidatableResponse createResponse = client.createCourier(courier);
        check.createdSuccessfully(createResponse);

        var creds = CourierCredentials.from(courier);
        ValidatableResponse loginResponse = client.loginCourier(creds);
        int id = check.loggedInSuccessfully(loginResponse);

        assertNotEquals(0, id);

        client.deleteCourier(id);
    }
}
