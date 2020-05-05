package io.github.jmgarridopaz.bluezone.driveradapters.forparkingcars.test.stepdefs;

import static org.junit.Assert.assertEquals;
import java.util.Map;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.PaymentCardInfo;
import io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.PermitRequest;
import io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.PermitTicket;


public class PermitStepDefs {

	private final ScenarioContext scenarioContext;
	
	public PermitStepDefs ( ScenarioContext scenarioContext ) {
		this.scenarioContext = scenarioContext;
	}


	@When("I do the following permit issuing request:")
	public void iDoTheFollowingPermitIssuingRequest ( DataTable dataTable ) {
		PermitRequest permitRequest = definePermitRequest(dataTable);
		PermitTicket permitTicket = ForParkingCarsProvider.INSTANCE.get().issuePermit ( this.scenarioContext.clock(), permitRequest );
		this.scenarioContext.setPermitTicket(permitTicket);
	}

	@Then("I should get the following permit ticket:")
	public void iShouldGetTheFollowingPermitTicket ( DataTable dataTable ) {
		PermitTicket expectedPermitTicket = definePermitTicket(dataTable);
		assertEquals ( expectedPermitTicket, this.scenarioContext.permitTicket() );
	}

	
    private static PermitRequest definePermitRequest ( DataTable dataTable ) {
    	Map<String, String> dataTableEntry = dataTable.asMaps().get(0);
		return new PermitRequest(dataTableEntry.get("carPlate"), dataTableEntry.get("rateName"), dataTableEntry.get("endingDateTime"), new PaymentCardInfo(dataTableEntry.get("cardNumber"), dataTableEntry.get("cardCvv"), dataTableEntry.get("cardExpirationDate")));
    }
		
    private static PermitTicket definePermitTicket ( DataTable dataTable ) {		
    	Map<String, String> dataTableEntry = dataTable.asMaps().get(0);
    	return new PermitTicket ( dataTableEntry.get("code"), dataTableEntry.get("carPlate"), dataTableEntry.get("rateName"), dataTableEntry.get("startingDateTime"), dataTableEntry.get("endingDateTime"), dataTableEntry.get("price") );
	}
	
}
