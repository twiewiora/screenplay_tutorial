package org.example.steps;

import static org.example.data.Notes.EMAIL;
import static org.example.data.Notes.PASSWORD;

import org.example.data.SimpleQuestion;
import org.example.data.SimpleTask;
import org.openqa.selenium.By;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class PreconditionSteps {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{word} has an account")
    public void userHasAnAccount(String name) {
        Actor user = OnStage.theActorCalled(name);
        user.remember(EMAIL, "tidara9879@yehudabx.com");
        user.remember(PASSWORD, "haslo123");
    }

    @And("{word} is on Login page")
    public void heIsOnLoginPage(String name) {
        Actor user = OnStage.theActor(name);

        user.wasAbleTo(
            Open.url("https://todoist.com"),
            Click.on(By.cssSelector("[href=\"/users/showlogin\"]"))
        );

        user.wasAbleTo(new SimpleTask());
    }
}
