package org.example.abilities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.serenitybdd.screenplay.Ability;

@Getter
@Setter
@AllArgsConstructor
public class AuthoriseHimself implements Ability {

    private String email;
    private String password;
    private String token;

    @Override
    public String toString() {
        return String.format("authorise himself using: %s / %s", email, password);
    }
}
