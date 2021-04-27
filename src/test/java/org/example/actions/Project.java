package org.example.actions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Task;
import org.example.tasks.CreateNewProject;

public class Project {

    public static Task createNewProject(String name) {
        return Instrumented.instanceOf(CreateNewProject.class).withProperties(name);
    }
}
