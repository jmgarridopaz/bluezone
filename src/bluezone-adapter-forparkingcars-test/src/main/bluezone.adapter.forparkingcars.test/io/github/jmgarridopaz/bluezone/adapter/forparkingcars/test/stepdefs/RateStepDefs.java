
package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.stepdefs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.jmgarridopaz.bluezone.hexagon.MoneyData;
import io.github.jmgarridopaz.bluezone.hexagon.RateData;
import io.github.jmgarridopaz.bluezone.hexagon.TimeTableData;


public class RateStepDefs {
	
	private final ScenarioContext scenarioContext;

	public RateStepDefs ( ScenarioContext scenarioContext ) {
		this.scenarioContext = scenarioContext;
	}


	
	@Given("there exist these rates:")
	public void thereExistTheseRates ( List<RateData> rateList ) {
		Set<RateData> rates = new HashSet<RateData>(rateList);
		this.scenarioContext.forParkingCars().addRatesToRepo ( rates );
	}
	
	@Given("there exist this rate")
	public void thereExistThisRate ( RateData rate ) {
		Set<RateData> rates = new HashSet<RateData>();
		rates.add(rate);
		this.scenarioContext.forParkingCars().addRatesToRepo ( rates );
	}

	@When("I request all the rates indexed by name")
	public void iRequestAllTheRatesIndexedByName() {
		Map<String,	RateData> ratesByName = this.scenarioContext.forParkingCars().getAllRatesByName();
		this.scenarioContext.setRatesByName(ratesByName);
	}


	@Then("I should get the following rates:")
	public void iShouldGetTheFollowingRates ( Map<String,RateData> expectedRates ) {
		Map<String,RateData> returnedRates = this.scenarioContext.ratesByName();
		assertThat ( returnedRates, is(expectedRates) );
	}

	
	@DataTableType
    public RateData rateEntry ( Map<String, String> entry ) {
		
		MoneyData costPerHour = new MoneyData();
		costPerHour.setAmount(new BigDecimal(entry.get("costPerHourAmount")));
		costPerHour.setCurrencyCode(entry.get("costPerHourCurrencyCode"));
		
		TimeTableData timeTable = new TimeTableData();
		timeTable.setMonday		( tableOfDay(entry, DayOfWeek.MONDAY));
		timeTable.setTuesday	( tableOfDay(entry, DayOfWeek.TUESDAY));
		timeTable.setWednesday	( tableOfDay(entry, DayOfWeek.WEDNESDAY));
		timeTable.setThursday	( tableOfDay(entry, DayOfWeek.THURSDAY));
		timeTable.setFriday		( tableOfDay(entry, DayOfWeek.FRIDAY));
		timeTable.setSaturday	( tableOfDay(entry, DayOfWeek.SATURDAY));
		timeTable.setSunday		( tableOfDay(entry, DayOfWeek.SUNDAY));
				
		RateData rate = new RateData();
		rate.setName(entry.get("name"));
		rate.setCostPerHour(costPerHour);
		rate.setMinMinutesAllowed(Integer.parseInt(entry.get("minMinutesAllowed")));
		rate.setMaxMinutesAllowed(Integer.parseInt(entry.get("maxMinutesAllowed")));
		rate.setTimetable(timeTable);
		
        return rate;
    }
	

	private String[] tableOfDay ( Map<String, String> dataTableEntry, DayOfWeek aDayOfWeek ) {
		String dayTableAsString = dataTableEntry.get ( aDayOfWeek.name().toLowerCase() );
    	if ( dayTableAsString == null ) {
    		return new String[0];
    	}
    	return dayTableAsString.split(" ");
	}
	
}
