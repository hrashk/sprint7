package org.example;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Client {
    static final String BASE_URI = "https://qa-scooter.praktikum-services.ru";
    static final String API_V1 = "/api/v1";

    protected RequestSpecification spec() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .basePath(API_V1);
    }
}
