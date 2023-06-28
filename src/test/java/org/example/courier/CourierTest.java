package org.example.courier;

import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

public class CourierTest {

    private final CourierGenerator generator = new CourierGenerator();
    private final CourierClient client = new CourierClient();
    private final CourierAssertions check = new CourierAssertions();
    protected int courierId;

    @After
    public void deleteCourier() {
        try {
//            var response = client.deleteCourier(courierId);
//            check.deleteSuccessfully(response);
        } catch (Exception npe){

        }
    }

    @Test
    public void createCourierAndLogInSuccesfully() {
//        Map<String, String> json = Map.of("login", "Jack", "password", "P@ssw0rd123", "firstName", "Sparrow");
        var courier = generator.random();
        ValidatableResponse courierResponse = client.createCourier(courier);
        check.createdSuccessfully(courierResponse);

        Credentials creds = Credentials.from(courier);
        ValidatableResponse loginResponse = client.logIn(creds);
        courierId = check.loggedInSuccessfully(loginResponse);
        assert courierId > 100;
    }
}
