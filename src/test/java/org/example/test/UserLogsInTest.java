package org.example.test;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.example.actions.Navigate;
import org.example.asserts.Should;
import org.example.pageobjects.LoginFormObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class UserLogsInTest {

    @Managed
    WebDriver driver;

    @Test
    public void user_with_invalid_credentials_cannot_logs_in() {
        Actor user = new Actor("User");
        user.can(BrowseTheWeb.with(driver));
        user.wasAbleTo(Navigate.toLoginPage());
        user.attemptsTo(
            LoginFormObject.fillWith("invalid", "invalid"),
            LoginFormObject.submit()
        );
        user.should(Should.notHaveACookie());
    }

}
