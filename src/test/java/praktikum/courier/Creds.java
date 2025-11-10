package praktikum.courier;

public class Creds {
    private final String login;
    private final String password;

    public Creds(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static Creds fromCourier(Courier c) {
        return new Creds(c.getLogin(), c.getPassword());
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
