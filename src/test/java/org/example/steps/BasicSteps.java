package org.example.steps;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BasicSteps {

    @Given("I'm Tomek!")
    public void i_m_tomek() {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("Hello World!")
    public void hello_world() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("String {string}")
    public void string(String stringValue) {
        System.out.println(stringValue);
    }

    @And("Number value {int}")
    public void numberValue(int value) {
        System.out.println(value);
    }

    @And("Float value {double}")
    public void floatValue(double value) {
        System.out.println(value);
    }

    @But("any word {word} be a {word}")
    public void anyWordMayBeAVariable(String val1, String val2) {
        System.out.println(val1 + " - " + val2);
    }

    @When("simple string list")
    public void simpleStringList(List<String> strings) {
        System.out.println(strings);
    }

    @When("another table")
    public void anotherTable(List<Map<String, String>> data) {
        System.out.println(data);
    }

    @And("one more table")
    public void oneMoreTable(Map<String, List<String>> data) {
        System.out.println(data);
    }

    @And("simple table")
    public void simpleTable(List<List<String>> table) {
        System.out.println(table);
    }

    @Then("magic multilines string")
    public void magicMultilinesString(String multilines) {
        System.out.println(multilines);
    }
}
