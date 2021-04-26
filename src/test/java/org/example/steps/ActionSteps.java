package org.example.steps;

import static org.example.data.Notes.EMAIL;
import static org.example.data.Notes.PASSWORD;

import org.openqa.selenium.By;

import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;

public class ActionSteps {

    @When("{word} enters correct mail and password")
    public void heEntersCorrectMailAndPassword(String name) {
        Actor user = OnStage.theActorCalled(name);

        user.attemptsTo(
                Enter.theValue((CharSequence) user.recall(EMAIL)).into(By.cssSelector("[type=\"email\"]")),
                Enter.theValue((CharSequence) user.recall(PASSWORD)).into(By.cssSelector("[type=\"password\"]")),
                Click.on(By.cssSelector("[class=\"submit_btn ist_button ist_button_red sel_login\"]"))
        );
    }

}
