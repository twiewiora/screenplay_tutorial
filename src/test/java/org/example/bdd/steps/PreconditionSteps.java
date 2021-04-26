package org.example.bdd.steps;

import org.example.abilities.AuthoriseHimself;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static org.example.actions.Navigate.*;

public class PreconditionSteps {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{actor} has an {userAccount}")
    public void userHasAnAccount(Actor user, AuthoriseHimself authorise) {
        user.can(authorise);
    }

    @And("{actor} is on Login page")
    public void heIsOnLoginPage(Actor user) {
        user.wasAbleTo(toLoginPage());
    }

    @Given("{actor} is on Main page")
    public void userIsOnMainPage(Actor user) {
        user.wasAbleTo(toLoginPage(), performUserLogin());
    }
}
