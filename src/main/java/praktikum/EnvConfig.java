package praktikum;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class EnvConfig {
    static {
        loadConfig();
    }

    public static final String BASE_URI = System.getProperty("base.uri"); // null

    private static void loadConfig() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        String fileName = System.getProperty("environment", "qa") + ".properties";
//        String fileName = "qa.properties";

        try (InputStream resource = contextClassLoader.getResourceAsStream(fileName)) {
            var props = new Properties();
            props.load(resource);

            Map<String, String> env = System.getenv();

            props.forEach((k,v) -> {
                if (env.containsKey(k)) {
                    System.setProperty(k.toString(), env.get(k));
                } else {
                    System.setProperty(k.toString(), v.toString());
                }
            });
//            System.getProperties().load(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
