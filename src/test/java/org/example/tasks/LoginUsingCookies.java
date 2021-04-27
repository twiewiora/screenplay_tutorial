package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.example.actions.Navigate;
import org.example.data.Session;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class LoginUsingCookies implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(Open.url("http://todoist.com/404"));
        WebDriver browser = actor.usingAbilityTo(BrowseTheWeb.class).getDriver();
        for(Cookie cookie : Session.COOKIES) {
            browser.manage().addCookie(cookie);
        }
        browser.navigate().to("http://todoist.com/app");
        actor.wasAbleTo(Navigate.waitForLoaderToClose());
    }
}
