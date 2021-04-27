package org.example.actions;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.SilentTask;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import org.example.data.Session;
import org.example.pageobjects.WelcomePageObject;
import org.example.tasks.LoginUsingCookies;
import org.example.tasks.LoginUsingCredentials;

import static java.util.Objects.nonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Navigate {

    public static Task performUserLogin() {
        return new LoginUsingCredentials();
    }

    public static Task toLoginPage() {
        return Task.where("{0} navigate to login page",
                Open.url("https://todoist.com"),
                WelcomePageObject.goToLoginPage()
        );
    }

    public static Task toMainPage() {
        if (nonNull(Session.COOKIES)) {
            SilentTask.where(
                new LoginUsingCookies()
            );
        }

        return SilentTask.where(
            Navigate.toLoginPage(),
            Navigate.performUserLogin()
        );
    }

}
