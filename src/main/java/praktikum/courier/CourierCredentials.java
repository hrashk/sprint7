package praktikum.courier;

public class CourierCredentials {
    private final String login;
    private final String password;

    public CourierCredentials(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static CourierCredentials fromCourier(Courier courier) {
        return new CourierCredentials(courier.getLogin(), courier.getPassword());
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
