package org.example.bdd.steps;

import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.QuestionConsequence;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.example.data.Session;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.example.asserts.Should.haveACookie;
import static org.example.data.Notes.PROJECT_NAME;

public class VerificationSteps {

    @Then("{actor} is logged in")
    public void heIsLoggedIn(Actor user) {
        user.should(haveACookie());

        WebDriver browser = user.usingAbilityTo(BrowseTheWeb.class).getDriver();
        Session.COOKIES = browser.manage().getCookies();
    }

    @Then("the project is created")
    public void theProjectIsCreated() {
        Actor user = OnStage.theActorInTheSpotlight();
        String cratedProjectName = user.recall(PROJECT_NAME);
        Target projectName = Target.the("project view header").located(By.cssSelector(".project_view h1"));

        user.should(new QuestionConsequence<>("Project name", Text.of(projectName).asAString(), Matchers.equalTo(cratedProjectName)));

    }
}
