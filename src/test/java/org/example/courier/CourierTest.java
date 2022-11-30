package org.example.courier;

import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

public class CourierTest {

    private final CourierClient client = new CourierClient();
    private int courierId;

    @After
    public void deleteCourier() {
        if (courierId > 0)
            client.delete(courierId);
    }

    @Test
    public void courier() {
        Courier courier = Courier.random();
        ValidatableResponse response = client.create(courier);
        client.assertCreatedSuccessfully(response);

        Credentials creds = Credentials.from(courier);
        ValidatableResponse loginResponse = client.logIn(creds);
        courierId = client.assertLoggedInSuccessfully(loginResponse);
    }

    @Test
    public void noPassword() {
        Courier courier = Courier.basic();
        courier.setPassword(null);
        ValidatableResponse response = client.create(courier);
        var message = client.assertCreationFailed(response, 400);
        System.out.println(message);
    }
}