package org.example.questions;

import org.openqa.selenium.Cookie;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class BrowserCookie implements Question<Cookie> {

    @Override
    public Cookie answeredBy(Actor actor) {
        BrowseTheWeb browser = actor.usingAbilityTo(BrowseTheWeb.class);
        return browser.getDriver().manage().getCookieNamed("todoistd");
    }
}
