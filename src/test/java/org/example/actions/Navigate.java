package org.example.actions;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.SilentTask;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import org.example.data.Session;
import org.example.tasks.LoginUsingCookies;
import org.example.tasks.LoginUsingCredentials;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;

import static java.util.Objects.nonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Navigate {

    private static Target loginLink = Target.the("login link").locatedBy("[href=\"/users/showlogin\"]");

    public static Task performUserLogin() {
        return new LoginUsingCredentials();
    }

    public static Task toLoginPage() {
        return Task.where("{0} navigate to login page",
                Open.url("https://todoist.com"),
                Click.on(loginLink)
        );
    }

    public static Performable waitForLoaderToClose() {
        return Wait.until(
            Visibility.of(By.cssSelector("#loading")).asABoolean(),
            Matchers.equalTo(false)
        ).forNoLongerThan(5).seconds();
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
