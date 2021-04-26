package org.example.actions;

import org.example.tasks.LoginUsingCredentials;
import org.openqa.selenium.By;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Navigate {

    public static Task performUserLogin() {
        return new LoginUsingCredentials();
    }

    public static Task toLoginPage() {
        return Task.where("navigate to login page",
                Open.url("https://todoist.com"),
                Click.on(By.cssSelector("[href=\"/users/showlogin\"]"))
        );
    }

}
