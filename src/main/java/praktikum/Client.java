package praktikum;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Client {
    static final String BASE_PATH = "/api/v1";

    public RequestSpecification spec() {
        return given().log().all()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .baseUri(EnvConfig.BASE_URI)
                .basePath(BASE_PATH)
                ;
    }
}
