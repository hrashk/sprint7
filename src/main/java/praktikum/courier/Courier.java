package praktikum.courier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

@Data
@AllArgsConstructor
@Builder
public class Courier {
    private String login;
    private String password;
    private String firstName;

    static Courier random() {
        return new Courier("Jack" + RandomStringUtils.randomAlphanumeric(5, 15),
                "P@ssw0rd123", "Sparrow");
    }

    static Courier withoutPassword() {
        return new Courier("Jack" + RandomStringUtils.randomAlphanumeric(5, 15),
                null, "Sparrow");
    }
}
