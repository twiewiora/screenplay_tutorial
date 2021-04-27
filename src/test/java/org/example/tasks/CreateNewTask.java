package org.example.tasks;

import io.restassured.http.ContentType;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.example.abilities.AuthoriseHimself;
import org.example.data.restapi.TaskRequest;

@RequiredArgsConstructor
public class CreateNewTask implements Task {

    private final String taskContent;
    private final long projectId;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Post.to("/tasks").with(req -> {
                req.headers("Authorization", actor.usingAbilityTo(AuthoriseHimself.class).getToken());
                req.contentType(ContentType.JSON);
                req.body(new TaskRequest(taskContent, projectId));
                return req;
            })
        );
    }
}
