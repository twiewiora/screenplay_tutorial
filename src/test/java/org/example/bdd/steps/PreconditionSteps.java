package org.example.bdd.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.SilentTask;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.example.abilities.AuthoriseHimself;
import org.example.actions.Navigate;
import org.example.actions.Project;
import org.example.data.restapi.ProjectResponse;
import org.example.facts.HasAuthorise;
import org.example.pageobjects.LoaderObject;

import static org.example.data.Notes.PROJECT_ID;

public class PreconditionSteps {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast(new Ability[]{CallAnApi.at("https://api.todoist.com/rest/v1")}));
    }

    @Given("{actor} has an {userAccount}")
    public void userHasAnAccount(Actor user, AuthoriseHimself authorise) {
        user.has(new HasAuthorise(authorise));
    }

    @And("{actor} is on Login page")
    public void heIsOnLoginPage(Actor user) {
        user.wasAbleTo(Navigate.toLoginPage());
    }

    @Given("{actor} is on Main page")
    public void userIsOnMainPage(Actor user) {
        user.wasAbleTo(Navigate.toMainPage());
    }

    @Given("{actor} has an {token}")
    public void userHasAnToken(Actor user, AuthoriseHimself authorise) {
        user.can(authorise);
    }

    @And("{actor} has a {projectName} created using rest")
    public void userHasAProjectCreatedUsingRest(Actor user, String projectName) {
        user.wasAbleTo(SilentTask.where(
            Project.createNewProjectWithRest(projectName)
        ));

        Response response = user.asksFor(LastResponse.received());
        ProjectResponse project = response.then().extract().body().as(ProjectResponse.class);
        user.remember(PROJECT_ID, project.getId());
    }

    @Given("{actor} has the {projectName} created")
    public void userHasTheProjectCreated(Actor user, String projectName) {
        user.wasAbleTo(SilentTask.where(
            Project.createNewProjectWithRest(projectName),
            LoaderObject.waitForLoaderToClose()
            )
        );

        Response response = user.asksFor(LastResponse.received());
        ProjectResponse project = response.then().extract().body().as(ProjectResponse.class);
        user.remember(PROJECT_ID, project.getId());
    }
}
