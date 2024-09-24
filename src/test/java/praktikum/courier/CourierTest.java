package praktikum.courier;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

import java.io.File;

public class CourierTest {
    private CourierClient client = new CourierClient();
    private CourierChecks check = new CourierChecks();

    int courierId;

    @After
    public void deleteCourier() {
        if (courierId != 0) {
            ValidatableResponse response = client.delete(courierId);
            check.deleted(response);
        }
    }

    @Test
    @DisplayName("удачливый курьер")
    public void courier() {
        var courier = Courier.random();
        ValidatableResponse createResponse = client.createCourier(courier);
        check.checkCreated(createResponse);

        var creds = CourierCredentials.fromCourier(courier);
        ValidatableResponse loginResponse = client.logIn(creds);
        courierId = check.checkLoggedIn(loginResponse);
    }

    @Test
    @DisplayName("поломанный курьер")
    public void cannotCreateWithoutPassword() {
        var courier = Courier.withoutPassword();
        ValidatableResponse createResponse = client.createCourier(courier);
        check.checkFailed(createResponse);
    }

    @Test
    @DisplayName("поломанный курьер")
    public void cannotCreateWithoutPassword2() {
        File json = new File("src/test/resources/brokenCourier.json");
        ValidatableResponse createResponse = client.createCourier(json);
        check.checkFailed(createResponse);
    }

    @Test
    @DisplayName("поломанный курьер")
    public void cannotCreateWithoutPassword3() {
        File json = new File("src/main/resources/broken.json");
        ValidatableResponse createResponse = client.createCourier(json);
        check.checkFailed(createResponse);
    }
}
