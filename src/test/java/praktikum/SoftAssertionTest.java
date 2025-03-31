package praktikum;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class SoftAssertionTest {
    @Rule
    public ErrorCollector ec = new ErrorCollector();

    @Test
    public void logIn() throws Exception {
        System.out.println("открыть страницу логина");
        //...

        // assertEquals
        ec.checkThat(getWebPageTitle(), CoreMatchers.is("login page"));

        System.out.println("залогиниться");
        // ...

        ec.checkThat(getWebPageTitle(), CoreMatchers.is("main page"));
    }

    private String getWebPageTitle() {
        return "some random title";
    }
}