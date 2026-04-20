package praktikum;

import java.io.IOException;
import java.io.InputStream;

public class EnvConfig {
    static {
        loadConfig();
    }

    public static final String BASE_URL = System.getProperty("base.uri"); // null

    private static void loadConfig() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        String fileName = System.getProperty("env", "qa") + ".properties";
//        String fileName = "qa.properties";

        try (InputStream resource = contextClassLoader.getResourceAsStream(fileName)) {
            System.getProperties().load(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
