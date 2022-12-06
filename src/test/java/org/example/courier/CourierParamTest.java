package org.example.courier;

import org.junit.runners.Parameterized;

public class CourierParamTest {

    @Parameterized.Parameters
    public Object[][] dataGen() {
        return new Object[][] {
                {"Jack", "Sparrow", new Object[] {"GRAY", "YELLOW"}},
                {"Jack", "Sparrow", new Object[] {"YELLOW"}},

        };
    }
}
