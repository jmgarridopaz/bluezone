package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.stepdefs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import java.util.Map;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;


public class PaymentStepDefs {

	private final ScenarioContext scenarioContext;
	
	public PaymentStepDefs ( ScenarioContext scenarioContext ) {
		this.scenarioContext = scenarioContext;
	}

	@Then("the following payment should have been done:")
	public void theFollowingPaymentShouldHaveBeenDone  ( DataTable aDataTable ) {
		Map<String,String> paymentSearchCriteria = aDataTable.asMaps().get(0);
		String cardNumber = paymentSearchCriteria.get("cardNumber");
		String amount = paymentSearchCriteria.get("amount");
		String currencyCode = paymentSearchCriteria.get("currencyCode");
		String permitTicketCode = paymentSearchCriteria.get("permitTicketCode");
		boolean paymentIsDone = this.scenarioContext.forParkingCars().paymentIsDone ( cardNumber, amount, currencyCode, permitTicketCode );
		assertThat(paymentIsDone,is(true));
	}
	
}
