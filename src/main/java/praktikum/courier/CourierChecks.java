package praktikum.courier;

import io.restassured.response.ValidatableResponse;

import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class CourierChecks {
    public void checkCreated(ValidatableResponse response) {
        boolean created = response
                .assertThat()
                .statusCode(HTTP_CREATED)
                .extract()
                .path("ok")
        ;
        assertTrue(created);
    }

    public int checkLoggedIn(ValidatableResponse loginResponse) {
        int id = loginResponse
                .assertThat()
                .statusCode(HTTP_OK)
                .extract()
                .path("id")
                ;


        assertNotEquals(0, id);

        return id;
    }
}
