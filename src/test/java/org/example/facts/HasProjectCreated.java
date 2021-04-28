package org.example.facts;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.facts.Fact;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.example.abilities.AuthoriseHimself;
import org.example.data.restapi.ProjectRequest;
import org.example.data.restapi.ProjectResponse;

import static org.example.data.Notes.PROJECT_ID;

@RequiredArgsConstructor
public class HasProjectCreated implements Fact {

    private final String projectName;

    @Override
    public void setup(Actor actor) {
        Post.to("/projects").with(req -> {
            req.headers("Authorization", actor.usingAbilityTo(AuthoriseHimself.class).getToken());
            req.contentType(ContentType.JSON);
            req.body(new ProjectRequest(projectName));
            return req;
        });
        Response response = actor.asksFor(LastResponse.received());
        ProjectResponse project = response.then().extract().body().as(ProjectResponse.class);
        actor.remember(PROJECT_ID, project.getId());
    }
}
