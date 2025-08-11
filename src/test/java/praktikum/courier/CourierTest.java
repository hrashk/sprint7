package praktikum.courier;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static io.restassured.RestAssured.given;

public class CourierTest {

    @Test
    public void courier() {
        var courier = Courier.random();

        boolean created = createCourier(courier)
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_CREATED)
                .extract()
                .path("ok")
        ;

        var creds = Credentials.from(courier);

        int id = given().log().all()
                .contentType(ContentType.JSON)
                .baseUri("https://qa-scooter.praktikum-services.ru")
                .body(creds)
                .when()
                .post("/api/v1/courier/login")
                .then().log().all()
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .extract()
                .path("id")
                ;


        assert created;
        assert id != 0;
    }

    private static ValidatableResponse createCourier(Courier courier) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri("https://qa-scooter.praktikum-services.ru")
                .body(courier)
                .when()
                .post("/api/v1/courier")
                .then().log().all();
    }
}
