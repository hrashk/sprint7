package org.example;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.io.InputStream;

import static io.restassured.RestAssured.given;

public class Client {
    static {
        loadConfig();
    }

    protected static final String BASE_URI = System.getProperty("base.uri");
    private static final String BASE_PATH = System.getProperty("base.path");

    private static void loadConfig() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        String fileName = System.getProperty("environment") + ".properties";
        System.out.println("read config from " + fileName);

        try (InputStream resource = contextClassLoader.getResourceAsStream(fileName)) {
            System.getProperties().load(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public RequestSpecification spec() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .basePath(BASE_PATH)
                ;
    }
}
