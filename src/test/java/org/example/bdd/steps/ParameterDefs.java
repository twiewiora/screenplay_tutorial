package org.example.bdd.steps;

import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import org.example.abilities.AuthoriseHimself;
import org.example.data.credentials.CredentialsGenerator;
import org.example.data.credentials.StaticCredentialsGenerator;
import org.example.data.generator.RandomTestDataGenerator;
import org.example.data.generator.StaticTestDataGenerator;
import org.example.data.generator.TestDataGenerator;

import java.util.ArrayList;
import java.util.List;

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

    @ParameterType("project")
    public String projectName(String value) {
        TestDataGenerator testDataGenerator = getGenerator();
        return testDataGenerator.getProjectName();
    }

    private TestDataGenerator getGenerator() {
        List<TestDataGenerator> generators = new ArrayList<>();
        generators.add(new RandomTestDataGenerator());
        generators.add(new StaticTestDataGenerator());

        String type = System.getProperty("testData", "static");
        for (TestDataGenerator generator : generators) {
            if (generator.isTypeOf(type)) {
                return generator;
            }
        }
        return new StaticTestDataGenerator();
    }

}
