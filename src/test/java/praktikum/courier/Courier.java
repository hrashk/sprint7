package praktikum.courier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courier {
    private String login;
    private  String password;
    private  String firstName;

    public static Courier random() {
        String login = "Jack" + ThreadLocalRandom.current().nextInt(1000, 100_10000);
        return new Courier(login, "P@ssw0rd123", "Sparrow");
    }
}
