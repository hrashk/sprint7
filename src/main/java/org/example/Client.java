package org.example;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Client {
    private static final String BASE_PATH = "/api/v1";
    private final String BASE_URI;

    public Client(String baseUri) {
        BASE_URI = baseUri;
    }

    public RequestSpecification spec() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .basePath(BASE_PATH)
                ;
    }
}
