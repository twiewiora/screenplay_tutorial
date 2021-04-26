package org.example.asserts;

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

}
