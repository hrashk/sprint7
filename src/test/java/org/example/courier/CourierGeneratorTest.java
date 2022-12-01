package org.example.courier;

import org.junit.Test;

import java.util.Objects;

public class CourierGeneratorTest {

    private CourierGenerator generator = new CourierGenerator();
    @Test
    public void generic() {
        var courier = generator.generic();
        assertIsValid(courier);
    }

    @Test
    public void random() {
        var courier = generator.random();
        assertIsValid(courier);
    }

    @Test
    public void twoRandomCouriers() {
        var courier = generator.random();
        var courier2 = generator.random();

        assert !Objects.equals(courier.getLogin(), courier2.getLogin());
    }

    private void assertIsValid(Courier courier) {
        assert courier.getLogin() != null;
        assert courier.getPassword() != null;
        assert courier.getFirstName() != null;
    }
}