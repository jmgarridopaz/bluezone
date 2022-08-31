package io.github.jmgarridopaz.bluezone.driver.forparkingcars.test.stepdefs;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.jmgarridopaz.bluezone.hexagon.Rate;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class RateStepDefs {

    private final ScenarioContext scenarioContext;

    public RateStepDefs(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @DataTableType
    public Rate rateEntry(Map<String, String> row) {
        String name = row.get("name");
        BigDecimal amountPerHour = new BigDecimal(row.get("amountPerHour"));
        return new Rate(name, amountPerHour);
    }

    @Given("there are the following rates at rate repository:")
    public void thereAreTheFollowingRatesAtRateRepository(List<Rate> rates) {
        this.scenarioContext.appConfigurator().createRates(rates);
    }

    @When("I ask for getting all rates by name")
    public void iAskForGettingAllRatesByName() {
        Map<String, Rate> ratesByName = this.scenarioContext.carParker().getAllRatesByName();
        this.scenarioContext.setCurrentRatesByName(ratesByName);
    }

    @Then("I should obtain the following rates indexed by name:")
    public void iShouldObtainTheFollowingRatesIndexedByName(Map<String, Rate> expectedRatesByName) {
        assertThat(this.scenarioContext.currentRatesByName(), is(expectedRatesByName));
    }

}
