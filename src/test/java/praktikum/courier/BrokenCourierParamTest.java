package praktikum.courier;

import io.qameta.allure.Allure;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BrokenCourierParamTest {
    private CourierClient client = new CourierClient();
    private CourierChecks check = new CourierChecks();

    private final String login;

    public BrokenCourierParamTest(String login) {
        this.login = login;
    }

    @Parameterized.Parameters(name = "login as {0}")
    public static Object[][] dataGenerator() {
        return new Object[][]{
                {"vaso"},
                {"nepetya"},
                {"masho"}
        };
    }

    @Test
    @DisplayName("поломанный курьер")
    public void cannotCreateWithoutPassword() {
        Allure.parameter("login", login);
        var courier = new Courier(login, null, "Sparrow");

        ValidatableResponse createResponse = client.createCourier(courier);

        check.checkFailed(createResponse);
    }
}
