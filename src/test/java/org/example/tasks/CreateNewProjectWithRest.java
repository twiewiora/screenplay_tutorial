package org.example.tasks;

import io.restassured.http.ContentType;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.example.abilities.AuthoriseHimself;
import org.example.data.restapi.ProjectRequest;

@RequiredArgsConstructor
public class CreateNewProjectWithRest implements Task {

    private final String projectName;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Post.to("/projects").with(req -> {
                req.headers("Authorization", actor.usingAbilityTo(AuthoriseHimself.class).getToken());
                req.contentType(ContentType.JSON);
                req.body(new ProjectRequest(projectName));
                return req;
            })
        );
        Task.where("Created project details", a ->
            Serenity.recordReportData().withTitle("Created project")
                .andContents(String.format("Project name: %s", projectName))
        );
    }
}
