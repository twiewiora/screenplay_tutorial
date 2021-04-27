package org.example.asserts;

import net.serenitybdd.screenplay.rest.questions.TheResponse;
import org.example.questions.BrowserCookie;
import org.hamcrest.Matchers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.QuestionConsequence;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Should {

    public static Consequence haveACookie() {
        return new QuestionConsequence("Cookie is there!", new BrowserCookie(), Matchers.notNullValue());
    }

    public static Consequence notHaveACookie() {
        return new QuestionConsequence("Cookie is not there!", new BrowserCookie(), Matchers.nullValue());
    }

    public static Consequence statusIs200() {
        return new QuestionConsequence<>("status code", TheResponse.statusCode(), Matchers.equalTo(200));
    }

}
