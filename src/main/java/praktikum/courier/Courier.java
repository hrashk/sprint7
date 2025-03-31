package praktikum.courier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.concurrent.ThreadLocalRandom;

@Builder
@Value
@AllArgsConstructor
public class Courier {
    private final String login;
    private final String password;
    private final String firstName;
    private final String lastName;

    public static Courier random() {
        int suffix = ThreadLocalRandom.current().nextInt(100, 100_000);
        return new Courier("Jack" + suffix, "P@ssw0rd123", "Sparrow", "");
    }
}
