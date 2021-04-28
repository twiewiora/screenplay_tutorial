package org.example.actions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Task;
import org.example.tasks.*;

public class Project {

    public static Task createNewProject(String name) {
        return Instrumented.instanceOf(CreateNewProject.class).withProperties(name);
    }

    public static Task createNewProjectWithRest(String name) {
        return Instrumented.instanceOf(CreateNewProjectWithRest.class).withProperties(name);
    }

    public static Task createTaskWithRest(String taskContent, long projectId) {
        return Instrumented.instanceOf(CreateNewTaskWithRest.class).withProperties(taskContent, projectId);
    }

    public static Task selectProject() {
        return Instrumented.instanceOf(SelectProject.class).newInstance();
    }

    public static Task createTask(String taskContent) {
        return Instrumented.instanceOf(CreateNewTask.class).withProperties(taskContent);
    }
}
