package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.stepdefs;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import io.cucumber.java.en.Given;


public class DateTimeStepDefs {

	private final ScenarioContext scenarioContext;

	public DateTimeStepDefs ( ScenarioContext scenarioContext ) {
		this.scenarioContext = scenarioContext;
	}


	@Given("current date time is {string}")
	public void currentDateTimeIs ( String aString ) {
		
		LocalDateTime dateTime = LocalDateTime.parse ( aString, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm") );
		
		Clock clock = Clock.fixed ( dateTime.toInstant(ZoneOffset.UTC), ZoneOffset.UTC );
		
		this.scenarioContext.setClockWithCurrentDateTime(clock);

	}
	
}
