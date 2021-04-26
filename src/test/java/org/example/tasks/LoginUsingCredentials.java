package org.example.tasks;

import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import org.example.abilities.AuthoriseHimself;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class LoginUsingCredentials implements Task {

    private static Target emailInput = Target.the("email input").locatedBy("#email");
    private static Target passwordInput = Target.the("password input").locatedBy("#password");
    private static Target loginButton = Target.the("login button").locatedBy(".sel_login");

    @Override
    public <T extends Actor> void performAs(T actor) {
        String email = actor.usingAbilityTo(AuthoriseHimself.class).getEmail();
        String password = actor.usingAbilityTo(AuthoriseHimself.class).getPassword();
        actor.attemptsTo(
                Task.where("Fills login form",
                        Enter.theValue(email).into(emailInput),
                        Enter.theValue(password).into(passwordInput),
                Click.on(loginButton))
        );
        actor.wasAbleTo(
            Wait.until(
                Visibility.of(By.cssSelector("#loading")).asABoolean(),
                Matchers.equalTo(false)
            ).forNoLongerThan(5).seconds()
        );
    }
}
