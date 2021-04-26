package org.example.bdd.steps;

import static org.example.asserts.Should.haveACookie;

import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;

public class VerificationSteps {

    @Then("{actor} is logged in")
    public void heIsLoggedIn(Actor user) {
        user.should(haveACookie());
    }

}
