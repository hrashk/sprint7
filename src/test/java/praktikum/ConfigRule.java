package praktikum;

import org.junit.rules.ExternalResource;

import java.io.IOException;
import java.io.InputStream;

public class ConfigRule extends ExternalResource {
    @Override
    protected void before() throws Throwable {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        String fileName = System.getProperty("environment", "qa") + ".properties";
//        String fileName = "config.properties";
        System.out.println("read config from " + fileName);

        try (InputStream resource = contextClassLoader.getResourceAsStream(fileName)) {
            System.getProperties().load(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
