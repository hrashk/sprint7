package praktikum;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// todo  .filter(new AllureRestAssured())

public class CourierTest {

    @Test
    public void courier() {
        String json = "{\"login\": \"Jack\", \"password\": \"P@ssw0rd123\", \"firstName\": \"Sparrow\"}";
        boolean created = given().log().all()
                .header("Content-Type", "application/json")
                .baseUri("https://qa-scooter.praktikum-services.ru")
                .body(json)
                .when()
                .post("/api/v1/courier")
                .then().log().all()
                .assertThat()
                .statusCode(201)
                .extract()
                .path("ok")
        ;

        String creds = "{\"login\": \"Jack\", \"password\": \"P@ssw0rd123\"}";
        int id = given().log().all()
                .header("Content-Type", "application/json")
                .baseUri("https://qa-scooter.praktikum-services.ru")
                .body(creds)
                .when()
                .post("/api/v1/courier/login")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id")
                ;


        assertTrue(created);
        assertNotEquals(0, id);
    }
}
