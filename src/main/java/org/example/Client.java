package org.example;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Client {
    protected static final String BASE_URI = "https://qa-scooter.praktikum-services.ru";
    protected static final String API = "/api/v1";

    public RequestSpecification spec() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .basePath(API);
    }
}
