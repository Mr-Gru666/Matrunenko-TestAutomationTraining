package org.traineProject.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchSteps {
    @Given("the user opens Google homepage")
    public void openGoogleHomepage() {
        open("https://www.google.com");
    }

    @When("the user searches for {string}")
    public void searchFor(String query) {
        $("[name='q']").setValue(query).pressEnter();
    }

    @Then("the search results should contain {string}")
    public void verifySearchResults(String expectedText) {
        $("#search").shouldHave(text(expectedText));
    }
}
