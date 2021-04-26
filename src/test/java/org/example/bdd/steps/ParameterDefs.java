package org.example.bdd.steps;

import org.example.abilities.AuthoriseHimself;
import org.example.data.credentials.CredentialsGenerator;
import org.example.data.credentials.StaticCredentialsGenerator;

import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

public class ParameterDefs {

    @ParameterType(".*")
    public Actor actor(String name) {
        return OnStage.theActorCalled(name);
    }

    @ParameterType("account")
    public AuthoriseHimself userAccount(String value) {
        CredentialsGenerator credentialsGenerator = new StaticCredentialsGenerator();
        return credentialsGenerator.getAccount();
    }

}
