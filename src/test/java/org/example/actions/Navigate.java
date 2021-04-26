package org.example.actions;

import net.serenitybdd.screenplay.targets.Target;
import org.example.tasks.LoginUsingCredentials;
import org.openqa.selenium.By;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Navigate {

    private static Target loginLink = Target.the("login link").locatedBy("[href=\"/users/showlogin\"]");

    public static Task performUserLogin() {
        return new LoginUsingCredentials();
    }

    public static Task toLoginPage() {
        return Task.where("Navigate to login page",
                Open.url("https://todoist.com"),
                Click.on(loginLink)
        );
    }

    public static Task toMainPage() {
        return Task.where("Navigate to main page",
            Open.url("https://todoist.com/app/today"),
            Click.on(loginLink)
        );
    }

}
