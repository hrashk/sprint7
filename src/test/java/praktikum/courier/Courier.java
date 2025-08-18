package praktikum.courier;

import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;

@Getter
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Courier {
    private String login;
    private String password;
    private String firstName;
    private String lastName;

    public static Courier random() {
//        return new Courier(String.format("Jack%sChan", RandomStringUtils.randomAlphanumeric(15)), "P@ssw0rd123", "Sparrow");
        return Courier.builder()
                .login(String.format("Jack%sChan", RandomStringUtils.randomAlphanumeric(15)))
                .password("P@ssw0rd123")
                .firstName("Sparrow")
                .build();
    }
}
