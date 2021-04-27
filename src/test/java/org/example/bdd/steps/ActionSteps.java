package org.example.bdd.steps;

import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import org.example.actions.Project;

import static org.example.actions.Navigate.performUserLogin;
import static org.example.data.Notes.PROJECT_NAME;

public class ActionSteps {

    @When("{actor} enters correct mail and password")
    public void heEntersCorrectMailAndPassword(Actor user) {
        user.attemptsTo(performUserLogin());
    }

    @When("{actor} creates a new {projectName}")
    public void heCreatesANewProject(Actor user, String projectName) {
        user.remember(PROJECT_NAME, projectName);
        user.attemptsTo(Project.createNewProject(projectName));
    }
}
