package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.example.pageobjects.ProjectsListObject;

import static org.example.data.Notes.PROJECT_ID;

public class SelectProject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        long projectId = actor.recall(PROJECT_ID);
        actor.attemptsTo(ProjectsListObject.selectProjectById(projectId));
    }
}
