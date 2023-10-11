package org.example;

import com.github.javafaker.Faker;
import org.example.courier.Courier;
import org.junit.Test;

public class LombokTests {

    @Test
    public void courier() {
        var f = new Faker();
        var c = new Courier(f.name().username(), f.internet().password(3, 10), f.name().firstName());
        System.out.println(c.getLogin());
        System.out.println(c.getPassword());
        System.out.println(c.getFirstName());
        System.out.println(c);
    }

    @Test
    public void courierBuilder() {
        var f = new Faker();
        var c = Courier.builder()
                .login(f.name().username())
                .password(f.internet().password(3, 10))
                .firstName(f.name().firstName())
                .lastName(f.name().lastName())
                .build();
        System.out.println(c);
    }
}
