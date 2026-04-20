package praktikum.courier;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Courier {
    private String login;
    private String password;
    private String firstName;

    @Step("используем курьера с рандомным логином")
    public static Courier random() {
        var random = ThreadLocalRandom.current();
        String randomLogin = "Jack" + random.nextInt();

        return Courier.builder()
                .login(randomLogin)
                .password("P@ssw0rd")
                .firstName("Sparrow")
                .build();
    }
}
