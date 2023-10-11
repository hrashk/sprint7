package org.example.courier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Courier {
    protected String login;
    protected String password;
    protected String firstName;
    protected String lastName;


    public Courier(String login, String password, String firstName) {
        this(login, password, firstName, null);
    }
}
