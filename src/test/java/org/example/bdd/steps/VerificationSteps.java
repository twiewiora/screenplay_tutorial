package org.example.bdd.steps;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.QuestionConsequence;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import net.serenitybdd.screenplay.targets.Target;
import org.example.data.Session;
import org.example.data.restapi.ProjectResponse;
import org.example.data.restapi.TaskResponse;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.example.asserts.Should.haveACookie;
import static org.example.asserts.Should.statusIs200;
import static org.example.data.Notes.*;

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

    @Then("project is created by rest")
    public void projectIsCreatedByRest() {
        Actor user = OnStage.theActorInTheSpotlight();

        Response response = user.asksFor(LastResponse.received());
        ProjectResponse project = response.then().extract().body().as(ProjectResponse.class);
        String projectName = user.recall(PROJECT_NAME);

        user.should(statusIs200(),
                    new QuestionConsequence<>("project name is correct", a -> project.getName(), Matchers.equalTo(projectName)));
    }

    @Then("task is created by rest")
    public void taskIsCreatedByRest() {
        Actor user = OnStage.theActorInTheSpotlight();

        Response response = user.asksFor(LastResponse.received());
        TaskResponse task = response.then().extract().body().as(TaskResponse.class);
        String taskContent = user.recall(TASK_CONTENT);
        long projectId = user.recall(PROJECT_ID);

        user.should(statusIs200(),
                    new QuestionConsequence<>("task content is correct", a -> task.getContent(), Matchers.equalTo(taskContent)),
                    new QuestionConsequence<>("task was created in correct project", a -> task.getProject_id(), Matchers.equalTo(projectId)));
    }
}
