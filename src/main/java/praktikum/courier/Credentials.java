package praktikum.courier;

import io.qameta.allure.Step;

public class Credentials {
    private final String login;
    private final String password;

    public Credentials(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Step("Логин/пароль курьера")
    public static Credentials fromCourier(Courier courier) {
        return new Credentials(courier.getLogin(), courier.getPassword());
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
