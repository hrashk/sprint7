package org.example.courier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

@Data
@AllArgsConstructor
@Builder
public class Courier {
    private String login;
    private String password;
    private String firstName;
    private String lastName;

    public static Courier generic() {
        return new Courier("Jackey", "P@ssw0rd123", "Sparrow", null);
    }

    public static Courier random() {
        return new Courier(RandomStringUtils.randomAlphabetic(5, 15), "P@ssw0rd123", "Sparrow", null);
    }
}
