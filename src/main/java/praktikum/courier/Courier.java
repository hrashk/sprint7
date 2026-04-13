package praktikum.courier;

import io.qameta.allure.Step;

import java.util.concurrent.ThreadLocalRandom;

public class Courier {
    private final String login;
    private final String password;
    private final String firstName;

    public Courier(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    @Step("используем курьера с рандомным логином")
    public static Courier random() {
        var random = ThreadLocalRandom.current();
        String randomLogin = "Jack" + random.nextInt();

        return new Courier(randomLogin, "P@ssw0rd", "Sparrow");
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

}
