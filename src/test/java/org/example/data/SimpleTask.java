package org.example.data;

import static org.example.data.Notes.EMAIL;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class SimpleTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("Hello I'm " + actor.getName() + " and this is my mail: " + actor.recall(EMAIL));
    }
}
