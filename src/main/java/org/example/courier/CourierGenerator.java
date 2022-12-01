package org.example.courier;

import org.apache.commons.lang3.RandomStringUtils;

public class CourierGenerator {
    public Courier generic() {
        return new Courier("Jack", "P@ssw0rd", "Sparrow");
    }

    public Courier random() {
        return new Courier(
                RandomStringUtils.randomAlphanumeric(10),
                RandomStringUtils.randomAlphanumeric(10),
                RandomStringUtils.randomAlphanumeric(10));
    }
}
