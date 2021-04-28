package org.example.tasks;

import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

@RequiredArgsConstructor
public class CreateNewTask implements Task {

    private final String taskContent;

    private static Target addButton = Target.the("create task").locatedBy("[class=\"plus_add_button\"]");
    private static Target taskContentInput = Target.the("fill task content").locatedBy("[data-text=\"true\"]");
    private static Target submitButton = Target.the("submit task").locatedBy("[class=\"ist_button ist_button_red\"]");

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(addButton),
            Enter.theValue(taskContent).into(taskContentInput),
            Click.on(submitButton)
        );
    }
}
