package org.example;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.Locale;

public class RandomStringTest {
    @Test
    public void randomStrings() {
        System.out.println(RandomStringUtils.random(11));
        System.out.println(RandomStringUtils.randomNumeric(13));
        System.out.println(RandomStringUtils.randomAlphabetic(17));
        System.out.println(RandomStringUtils.randomAlphanumeric(23));
        System.out.printf("autotest_${name}@ya.ru", RandomStringUtils.randomAlphanumeric(15));
    }

    @Test
    public void faker() {
        var f = new Faker();
        System.out.println(f.letterify("????##@ya.ru"));
        System.out.println(f.numerify("????##@ya.ru"));
        System.out.println(f.bothify("????##@ya.ru"));
        System.out.println(f.regexify("[0-9a-zA-Z]{10}"));
    }

    @Test
    public void fakerLocales() {
        var uk = new Faker(Locale.UK);
        var ru = new Faker(new Locale("ru"));

        System.out.println(ru.address().city());
        System.out.println(ru.address().zipCode());
        System.out.println();

        System.out.println(uk.address().city());
        System.out.println(uk.address().zipCode());
        System.out.println();

        System.out.println(ru.name().fullName());

        System.out.println(uk.animal().name());

        System.out.println(ru.lorem().paragraph(15));

        System.out.println(ru.phoneNumber().phoneNumber());
    }
}
