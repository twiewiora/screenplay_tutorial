package org.example.tasks;

import org.example.abilities.AuthoriseHimself;
import org.openqa.selenium.By;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class LoginUsingCredentials implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String email = actor.usingAbilityTo(AuthoriseHimself.class).getEmail();
        String password = actor.usingAbilityTo(AuthoriseHimself.class).getPassword();
        actor.attemptsTo(
                Task.where("fills login form",
                        Enter.theValue(email).into(By.cssSelector("[type=\"email\"]")),
                        Enter.theValue(password).into(By.cssSelector("[type=\"password\"]"))),
                Click.on(By.cssSelector("[class=\"submit_btn ist_button ist_button_red sel_login\"]"))
        );
    }
}
