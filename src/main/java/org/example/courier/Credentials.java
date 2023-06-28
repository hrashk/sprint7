package org.example.courier;

public class Credentials {
    private String login;
    private String password;

    public Credentials() {
    }

    public Credentials(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static Credentials from(Courier courier) {
        Credentials c = new Credentials();
        c.setLogin(courier.getLogin());
        c.setPassword(courier.getPassword());
        return c;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
