package org.example.courier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class CourierParamTest {

    private List<String> color;

    public CourierParamTest(List<String> color) {
        this.color = color;
    }

    @Parameterized.Parameters
    public static Object[][] dataGen() {
        return new Object[][] {
                {List.of("GRAY", "YELLOW")},
                {List.of("YELLOW")},
        };
    }

    @Test public void checkEm() {
        System.out.println(color);
    }
}
