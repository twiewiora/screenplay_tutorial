package org.example.actions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Task;
import org.example.tasks.CreateNewProject;
import org.example.tasks.CreateNewProjectWithRest;
import org.example.tasks.CreateNewTask;

public class Project {

    public static Task createNewProject(String name) {
        return Instrumented.instanceOf(CreateNewProject.class).withProperties(name);
    }

    public static Task createNewProjectWithRest(String name) {
        return Instrumented.instanceOf(CreateNewProjectWithRest.class).withProperties(name);
    }

    public static Task createTask(String taskContent, long projectId) {
        return Instrumented.instanceOf(CreateNewTask.class).withProperties(taskContent, projectId);
    }
}
