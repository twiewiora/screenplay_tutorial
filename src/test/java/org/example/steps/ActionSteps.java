package org.example.steps;

import org.example.abilities.AuthoriseHimself;
import org.openqa.selenium.By;

import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class ActionSteps {

    @When("{actor} enters correct mail and password")
    public void heEntersCorrectMailAndPassword(Actor user) {
        String email = user.usingAbilityTo(AuthoriseHimself.class).getEmail();
        String password = user.usingAbilityTo(AuthoriseHimself.class).getPassword();
        user.attemptsTo(
                Enter.theValue(email).into(By.cssSelector("[type=\"email\"]")),
                Enter.theValue(password).into(By.cssSelector("[type=\"password\"]")),
                Click.on(By.cssSelector("[class=\"submit_btn ist_button ist_button_red sel_login\"]"))
        );
    }

}
