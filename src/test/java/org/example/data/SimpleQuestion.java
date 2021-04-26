package org.example.data;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class SimpleQuestion implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return "test result";
    }
}
