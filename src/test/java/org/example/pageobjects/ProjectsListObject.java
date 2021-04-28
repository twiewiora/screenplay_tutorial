package org.example.pageobjects;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProjectsListObject {

    private static Target createProjectLink = Target.the("create project link").locatedBy("[data-track=\"navigation|projects_quick_add\"]");

    public static Task clickNewProjectLink() {
        return Task.where("{0} click new project link",
            MoveMouse.to(createProjectLink),
            Click.on(createProjectLink)
        );
    }

    public static Task selectProjectById(long id) {
        String selector = String.format("[data-id=\"%d\"]", id);
        Target project = Target.the("project to select").located(By.cssSelector(selector));

        return Task.where("{0} select project", Click.on(project));
    }
}
