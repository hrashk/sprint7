package org.example.courier;

import org.apache.commons.lang3.RandomStringUtils;

public class CourierGenerator {
    public static Courier generic() {
        return new Courier("Jack", "P@ssw0rd123", "Sparrow");
    }

    public static Courier random() {
        return new Courier(RandomStringUtils.randomAlphanumeric(5, 10), "P@ssw0rd123", "Sparrow");
    }
}
