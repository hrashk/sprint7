package praktikum.courier;

import java.time.LocalDateTime;

public class Courier {
    private String login;
    private String password;
    private String firstName;

    public Courier(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    public static Courier random() {
        var rnd = LocalDateTime.now().getNano();
        return new Courier("Jack" + rnd, "P@ssw0rd123", "Sparrow");
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
