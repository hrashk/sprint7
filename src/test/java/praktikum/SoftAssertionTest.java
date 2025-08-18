package praktikum;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SoftAssertionsExtension.class)
public class SoftAssertionTest {
    @Test
    public void logIn(SoftAssertions softly) {
        System.out.println("открыть страницу логина");
        //...

        // assertEquals
        softly.assertThat(getWebPageTitle()).isEqualTo("login page");

        System.out.println("залогиниться");
        // ...

        softly.assertThat(getWebPageTitle()).isEqualTo("main page");
    }

    private String getWebPageTitle() {
        return "some random title";
    }
}