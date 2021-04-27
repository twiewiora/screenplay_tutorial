package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.example.abilities.AuthoriseHimself;
import org.example.pageobjects.LoaderObject;
import org.example.pageobjects.LoginFormObject;

public class LoginUsingCredentials implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String email = actor.usingAbilityTo(AuthoriseHimself.class).getEmail();
        String password = actor.usingAbilityTo(AuthoriseHimself.class).getPassword();
        actor.attemptsTo(
            LoginFormObject.fillWith(email, password),
            LoginFormObject.submit()
        );
        actor.wasAbleTo(LoaderObject.waitForLoaderToClose());
    }
}
