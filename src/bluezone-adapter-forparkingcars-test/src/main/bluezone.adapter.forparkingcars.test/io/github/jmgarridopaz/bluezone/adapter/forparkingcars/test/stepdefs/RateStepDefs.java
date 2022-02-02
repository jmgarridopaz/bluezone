package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.stepdefs;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.jmgarridopaz.bluezone.hexagon.ForParkingCars;
import io.github.jmgarridopaz.bluezone.hexagon.RateData;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class RateStepDefs {
	
	private final ScenarioContext scenarioContext;

	public RateStepDefs ( ScenarioContext scenarioContext ) {
		this.scenarioContext = scenarioContext;
	}

	
	@Given("it does not exist any rate repository")
	public void itDoesNotExistAnyRateRepository() {
		this.scenarioContext.setExistSomeRateRepository(false);
	}

	@Given("there exist the following rates at rate repository:")
	public void thereExistTheFollowingRatesAtRateRepository( List<RateData> rates ) {
		this.scenarioContext.setInitialRates ( new HashSet<RateData>(rates) );
	}

	@When("I do a get all rates by name request")
	public void iDoAGetAllRatesByNameRequest() {
		ForParkingCars forParkingCars = this.scenarioContext.systemUnderTest();
		Map<String,	RateData> ratesByName = forParkingCars.getAllRatesByName();
		this.scenarioContext.setExistingRatesByName(ratesByName);
	}

	@Then("I should obtain the following get all rates by name response:")
	public void iShouldObtainTheFollowingGetAllRatesByNameResponse ( Map<String,RateData> expectedRatesByName ) {
		assertThat ( this.scenarioContext.getExistingRatesByName(), is(expectedRatesByName) );
	}


	@DataTableType
	public RateData rateEntry ( Map<String, String> entry ) {
		RateData rate = new RateData();
		rate.setName(entry.get("name"));
		rate.setAmountPerHour(new BigDecimal(entry.get("amount per hour")));
		rate.setMinMinutesAllowed(Integer.parseInt(entry.get("min minutes allowed")));
		rate.setMaxMinutesAllowed(Integer.parseInt(entry.get("max minutes allowed")));
		return rate;
	}

}
