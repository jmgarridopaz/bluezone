package io.github.jmgarridopaz.bluezone.driveradapters.forparkingcars.test.stepdefs;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.RateInfo;
import io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.Timetable;
import io.github.jmgarridopaz.lib.javalangutils.CollectionUtils;


public class RateStepDefs {
	
	private final ScenarioContext scenarioContext;

	public RateStepDefs ( ScenarioContext scenarioContext ) {
		this.scenarioContext = scenarioContext;
	}

	
	@When("I request all the rates")
	public void iRequestAllTheRates() {
		Set<RateInfo> rates = ForParkingCarsProvider.INSTANCE.get().getAllRates();
		this.scenarioContext.setRates(rates);
	}

	@Then("I should get the following rates:")
	public void iShouldGetTheFollowingRates ( DataTable dataTable ) {
		Set<RateInfo> expectedRates = defineRates(dataTable);
		assertTrue ( CollectionUtils.equals ( expectedRates, scenarioContext.rates() ) );
	}

	
    private static Set<RateInfo> defineRates ( DataTable dataTable ) {
		Set<RateInfo> rates = new HashSet<RateInfo>();
    	for ( Map<String,String> dataTableEntry : dataTable.asMaps() ) {
    		RateInfo rateInfo = new RateInfo(dataTableEntry.get("name"), dataTableEntry.get("costPerHour"), dataTableEntry.get("minutesAllowedInterval"), new Timetable(dataTableEntry.get("monday"),dataTableEntry.get("tuesday"),dataTableEntry.get("wednesday"),dataTableEntry.get("thursday"),dataTableEntry.get("friday"),dataTableEntry.get("saturday"),dataTableEntry.get("sunday")));
			rates.add(rateInfo);
    	}
    	return rates;
	}
	
}
