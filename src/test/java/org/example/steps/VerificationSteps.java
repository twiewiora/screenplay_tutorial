package org.example.steps;

import org.example.questions.BrowserCookie;
import org.hamcrest.Matchers;

import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.QuestionConsequence;

public class VerificationSteps {

    @Then("{actor} is logged in")
    public void heIsLoggedIn(Actor user) {

        //robi się tak, żeby było widoczne na raporcie
        QuestionConsequence hasACookie = new QuestionConsequence("Cookie is there!", new BrowserCookie(),
                Matchers.notNullValue());
        user.should(hasACookie);
    }

}
