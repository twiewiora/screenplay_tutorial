package org.example.pageobjects;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginFormObject {
    private static Target emailInput = Target.the("email input").locatedBy("#email");
    private static Target passwordInput = Target.the("password input").locatedBy("#password");
    private static Target loginButton = Target.the("login button").locatedBy(".sel_login");

    public static Task fillWith(String email, String password) {
        return Task.where("{0} fills login form",
            Enter.theValue(email).into(emailInput),
            Enter.theValue(password).into(passwordInput)
        );
    }

    public static Task submit() {
        return Task.where("{0} submit the form", Click.on(loginButton));
    }

}
