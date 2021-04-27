package org.example.pageobjects;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WelcomePageObject {

    private static Target loginLink = Target.the("login link").locatedBy("[href=\"/users/showlogin\"]");

    public static Performable goToLoginPage() {
        return Click.on(loginLink);
    }

}
