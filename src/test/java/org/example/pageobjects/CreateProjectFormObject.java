package org.example.pageobjects;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateProjectFormObject {

    private static Target projectNameInput = Target.the("project name input").locatedBy("#edit_project_modal_field_name");
    private static Target addButton = Target. the("login button").locatedBy("[class=\"ist_button ist_button_red\"]");

    public static Task fillWith(String name) {
        return Task.where("{0} fill project name",
            Enter.theValue(name).into(projectNameInput)
        );
    }

    public static Task submit() {
        return Task.where("{0} submit the form",
            Click.on(addButton)
        );
    }

}
