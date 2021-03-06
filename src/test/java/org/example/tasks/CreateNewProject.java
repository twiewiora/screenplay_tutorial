package org.example.tasks;

import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.example.pageobjects.CreateProjectFormObject;
import org.example.pageobjects.ProjectsListObject;

@RequiredArgsConstructor
public class CreateNewProject implements Task {

    private final String projectName;

    private static Target createProjectLink = Target.the("create project link").locatedBy("[data-track=\"navigation|projects_quick_add\"]");
    private static Target projectNameInput = Target.the("project name input").locatedBy("#edit_project_modal_field_name");
    private static Target addButton = Target. the("login button").locatedBy("[class=\"ist_button ist_button_red\"]");

    @Override
    @Step("dowolna nazwa kroku, wykonana przez: {0}, tworzy projekt: #projectName")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            ProjectsListObject.clickNewProjectLink(),
            CreateProjectFormObject.fillWith(projectName),
            CreateProjectFormObject.submit()
        );
    }
}
