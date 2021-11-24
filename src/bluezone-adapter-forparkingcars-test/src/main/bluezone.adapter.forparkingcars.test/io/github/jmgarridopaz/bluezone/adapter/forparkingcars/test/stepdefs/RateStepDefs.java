package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.stepdefs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.jmgarridopaz.bluezone.hexagon.ForObtainingRates;
import io.github.jmgarridopaz.bluezone.hexagon.ForParkingCars;
import io.github.jmgarridopaz.bluezone.hexagon.RateData;


public class RateStepDefs {
	
	private final ScenarioContext scenarioContext;

	public RateStepDefs ( ScenarioContext scenarioContext ) {
		this.scenarioContext = scenarioContext;
	}

	
	@Given("it does not exist any rate repository")
	public void itDoesNotExistAnyRateRepository() {
		this.scenarioContext.setExistSomeRateRepository(false);
	}

	@Given("there are the following rates at the repository:")
	public void thereAreTheFollowingRatesAtTheRepository ( List<RateData> rates ) {
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
		rate.setAmountPerHour(new BigDecimal(entry.get("amountPerHour")));
		rate.setMinMinutesAllowed(Integer.parseInt(entry.get("minMinutesAllowed")));
		rate.setMaxMinutesAllowed(Integer.parseInt(entry.get("maxMinutesAllowed")));		
		return rate;
	}

/////////////////////////////////////////////////////////////////////////////////////////7	
//	
//	@Given("it does not exist any rate repository")
//	public void noRateRepositoryIsPresent() {
//		this.scenarioContext.setNoRateRepositoryPresent(true);
//	}
//
//	@When("I request all the rates indexed by name")
//	public void iRequestAllTheRatesIndexedByName() {
//		ForParkingCars forParkingCars = this.scenarioContext.systemUnderTest();
//		Map<String,	RateData> ratesByName = forParkingCars.getAllRatesByName();
//		this.scenarioContext.setExistingRatesByName(ratesByName);
//	}
//
	
//////////////////////////////////////////////////////////////////////////////////////////////	
	
//	@Given("there exist these rates:")
//	public void thereExistTheseRates ( List<RateData> rates ) {
//		ForObtainingRates rateRepository = DrivenSide.getInstance().initRateRepositoryWith ( new HashSet<RateData>(rates) );
//		this.scenarioContext.setRateRepository ( rateRepository );
//	}
//	
//	@Given("there exist this rate")
//	public void thereExistThisRate ( RateData rate ) {
//		Set<RateData> rates = new HashSet<RateData>();
//		rates.add(rate);
//		ForObtainingRates rateRepository = DrivenSide.getInstance().initRateRepositoryWith ( rates );
//		this.scenarioContext.setRateRepository ( rateRepository );
//	}

//
//	@Then("I should get the following rates:")
//	public void iShouldGetTheFollowingRates ( Map<String,RateData> expectedRatesByName ) {
//		assertThat ( this.scenarioContext.getExistingRatesByName(), is(expectedRatesByName) );
//	}
//
//	
//	@DataTableType
//    public RateData rateEntry ( Map<String, String> entry ) {
//		RateData rate = new RateData();
//		rate.setName(entry.get("name"));
//		BigDecimal amountPerHour = new BigDecimal(entry.get("amountPerHour"));
//		amountPerHour.setScale(2,RoundingMode.HALF_UP);
//		rate.setAmountPerHour(amountPerHour);
//		rate.setMinMinutesAllowed(Integer.parseInt(entry.get("minMinutesAllowed")));
//		rate.setMaxMinutesAllowed(Integer.parseInt(entry.get("maxMinutesAllowed")));		
//        return rate;
//    }
//	
}
