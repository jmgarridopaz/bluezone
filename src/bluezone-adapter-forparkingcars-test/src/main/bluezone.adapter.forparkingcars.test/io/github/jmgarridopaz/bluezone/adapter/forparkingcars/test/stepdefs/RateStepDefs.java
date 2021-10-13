
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
import io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.DrivenSide;
import io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.DriverPortBuilder;
import io.github.jmgarridopaz.bluezone.hexagon.ForObtainingRates;
import io.github.jmgarridopaz.bluezone.hexagon.ForParkingCars;
import io.github.jmgarridopaz.bluezone.hexagon.RateData;


public class RateStepDefs {
	
	private final ScenarioContext scenarioContext;

	public RateStepDefs ( ScenarioContext scenarioContext ) {
		this.scenarioContext = scenarioContext;
	}


/////////////////////////////////////////////////////////////////////////////////////////7	
	
	@Given("no rate repository is present")
	public void noRateRepositoryIsPresent() {
		this.scenarioContext.setNoRateRepositoryPresent(true);
	}

	@Given("no permit repository is present")
	public void noPermitRepositoryIsPresent() {
		this.scenarioContext.setNoPermitRepositoryPresent(true);
	}

	@Given("no payment recipient is present")
	public void noPaymentRecipientIsPresent() {
		this.scenarioContext.setNoPaymentRecipientPresent(true);
	}

	@When("I request all the rates indexed by name")
	public void iRequestAllTheRatesIndexedByName() {
		ForParkingCars forParkingCars = DriverPortBuilder.getInstance().forParkingCars ( rateRepository() , permitRepository, paymentRecipient );
		Map<String,	RateData> ratesByName = forParkingCars.getAllRatesByName();
		this.scenarioContext.setExistingRatesByName(ratesByName);
	}


	@Then("I should get the following rates:")
	public void iShouldGetTheFollowingRates(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    throw new io.cucumber.java.PendingException();
	}
	
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


	@Then("I should get the following rates:")
	public void iShouldGetTheFollowingRates ( Map<String,RateData> expectedRatesByName ) {
		assertThat ( this.scenarioContext.existingRatesByName(), is(expectedRatesByName) );
	}

	
	@DataTableType
    public RateData rateEntry ( Map<String, String> entry ) {
		RateData rate = new RateData();
		rate.setName(entry.get("name"));
		BigDecimal amountPerHour = new BigDecimal(entry.get("amountPerHour"));
		amountPerHour.setScale(2,RoundingMode.HALF_UP);
		rate.setAmountPerHour(amountPerHour);
		rate.setMinMinutesAllowed(Integer.parseInt(entry.get("minMinutesAllowed")));
		rate.setMaxMinutesAllowed(Integer.parseInt(entry.get("maxMinutesAllowed")));		
        return rate;
    }
	
}
