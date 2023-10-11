package org.example.courier;

import io.restassured.response.ValidatableResponse;
import org.aeonbits.owner.ConfigFactory;
import org.example.AppConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourierTest {

    private AppConfig appConfig;

    private CourierClient client;
    private final CourierAssertions check = new CourierAssertions();
    protected int courierId;

    @Before
    public void loadConfig() {
        appConfig = ConfigFactory.create(AppConfig.class);
        client = new CourierClient(appConfig.baseUrl());
    }

    @After
    public void deleteCourier() {
        ValidatableResponse delete = client.delete(courierId);
        check.deletedSuccessfully(delete);
    }

    @Test
    public void courier() {
        var courier = CourierGenerator.random();

        ValidatableResponse response = client.create(courier);
        check.createdSuccessfully(response);

        var creds = Credentials.from(courier);

        ValidatableResponse loginResponse = client.login(creds);
        courierId = check.loggedInSuccessfully(loginResponse);

        assert courierId != 0;
    }
}
