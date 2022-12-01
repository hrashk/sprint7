package org.example.courier;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.text.CharSequenceLength;
import org.junit.After;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class CourierTest {

    private final CourierClient client = new CourierClient();
    private final CourierGenerator generator = new CourierGenerator();
    private final CourierChecks check = new CourierChecks();
    private int courierId;

    @After
    public void deleteCourier() {
        if (courierId > 0)
            client.delete(courierId);
    }

    @DisplayName("Успешное созддание курьера")
    @Test
    public void newCourierCanLogIn() {
        var courier = generator.random();
        var response = client.create(courier);
        check.createdSuccessfully(response);

        Credentials creds = Credentials.from(courier);
        ValidatableResponse loginResponse = client.logIn(creds);
        courierId = check.loggedInSuccessfully(loginResponse);
    }

    @DisplayName("Курьера без пароля создать нельзя")
    @Test
    public void cannotCreateCourierWithoutPassword() {
        var courier = generator.generic();
        courier.setPassword(null);

        ValidatableResponse response = client.create(courier);

        var message = check.creationFailed(response, 400);
        assertThat(message, CharSequenceLength.hasLength(greaterThan(10)));
    }
}
