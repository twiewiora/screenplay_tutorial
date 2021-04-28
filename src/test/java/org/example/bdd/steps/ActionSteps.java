package org.example.bdd.steps;

import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import org.example.actions.Project;

import static org.example.actions.Navigate.performUserLogin;
import static org.example.data.Notes.*;

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

    @When("{actor} creates new {projectName} using rest")
    public void userCreatesNewProjectUsingRest(Actor user, String projectName) {
        user.remember(PROJECT_NAME, projectName);
        user.attemptsTo(Project.createNewProjectWithRest(projectName));
    }

    @When("{actor} adds a {taskContent} to the project using rest")
    public void heAddsATaskToTheProjectUsingRest(Actor user, String taskContent) {
        user.remember(TASK_CONTENT, taskContent);
        long projectId = user.recall(PROJECT_ID);

        user.attemptsTo(Project.createTaskWithRest(taskContent, projectId));
    }

    @When("{actor} creates new {taskContent} in the project")
    public void heCreatesNewTaskInTheProject(Actor user, String taskContent) {
        user.remember(TASK_CONTENT, taskContent);
        user.attemptsTo(
            Project.selectProject(),
            Project.createTask(taskContent)
        );
    }
}
