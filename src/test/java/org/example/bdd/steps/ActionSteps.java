package org.example.bdd.steps;

import static org.example.actions.Navigate.performUserLogin;

import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

public class ActionSteps {

    @When("{actor} enters correct mail and password")
    public void heEntersCorrectMailAndPassword(Actor user) {
        user.attemptsTo(performUserLogin());
    }

}
