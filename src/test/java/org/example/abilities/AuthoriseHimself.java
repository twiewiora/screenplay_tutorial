package org.example.abilities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.serenitybdd.screenplay.Ability;

@Getter
@Setter
@AllArgsConstructor
public class AuthoriseHimself implements Ability {

    private final String email;
    private final String password;

}
