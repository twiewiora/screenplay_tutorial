package org.example.facts;

import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.facts.Fact;
import org.example.abilities.AuthoriseHimself;

@RequiredArgsConstructor
public class HasAuthorise implements Fact {

    private final AuthoriseHimself authorise;

    @Override
    public void setup(Actor actor) {
        actor.can(authorise);
    }
}
