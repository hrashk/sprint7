package praktikum;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.io.InputStream;

import static io.restassured.RestAssured.given;

public class Client {
    static {
        loadConfig();
    }
//    private static final String BASE_URI = "https://qa-scooter.praktikum-services.ru";
    private static final String BASE_URI = System.getProperty("base.uri");
    private static final String BASE_PATH = System.getProperty("base.path");
//    private static final String BASE_PATH = "/api/v1";

    public RequestSpecification spec() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .basePath(BASE_PATH)
                ;
    }

    private static void loadConfig() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        String fileName = System.getProperty("environment", "config") + ".properties";
//        String fileName = "config.properties";
        System.out.println("read config from " + fileName);

        try (InputStream resource = contextClassLoader.getResourceAsStream(fileName)) {
            System.getProperties().load(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
