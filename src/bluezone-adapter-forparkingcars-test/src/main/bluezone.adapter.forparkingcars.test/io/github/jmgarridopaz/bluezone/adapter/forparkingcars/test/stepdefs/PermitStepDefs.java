package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.stepdefs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.hamcrest.Matcher;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.jmgarridopaz.bluezone.hexagon.ForParkingCars;
import io.github.jmgarridopaz.bluezone.hexagon.PaymentCardData;
import io.github.jmgarridopaz.bluezone.hexagon.PermitRequest;
import io.github.jmgarridopaz.bluezone.hexagon.PermitTicket;


public class PermitStepDefs {

	private final ScenarioContext scenarioContext;
	
	public PermitStepDefs ( ScenarioContext scenarioContext ) {
		this.scenarioContext = scenarioContext;
	}


	@Given("it does not exist any permit repository")
	public void itDoesNotExistAnyPermitRepository() {
		this.scenarioContext.setExistSomePermitRepository(false);
	}

	@When("I do the following issue permit request:")
	public void iDoTheFollowingIssuePermitRequest ( PermitRequest permitRequest ) {
		ForParkingCars forParkingCars = this.scenarioContext.systemUnderTest();
		PermitTicket permitTicket = forParkingCars.issuePermit ( permitRequest );
		this.scenarioContext.setIssuedPermitTicket(permitTicket);
	}

	@Then("I should obtain the following issue permit response:")
	public void iShouldObtainTheFollowingIssuePermitResponse ( PermitTicket expectedPermitTicket ) {
		assertThat ( this.scenarioContext.getIssuedPermitTicket(), is(expectedPermitTicket) );
	}


//	@When("I do the following issue permit request at {string}:")
//	public void iDoTheFollowingIssuePermitRequestAt ( String aString, PermitRequest permitRequest ) {
//		ForParkingCars forParkingCars = this.scenarioContext.systemUnderTest();
//		LocalDateTime currentDateTime = LocalDateTime.parse ( aString, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm") );
//		Clock clockWithCurrentDateTime = Clock.fixed ( currentDateTime.toInstant(ZoneOffset.UTC), ZoneOffset.UTC );
//		PermitTicket permitTicket = forParkingCars.issuePermit ( clockWithCurrentDateTime, permitRequest );
//		this.scenarioContext.setIssuedPermitTicket(permitTicket);
//	}
//
//
//	@Then("I should get the following issue permit response:")
//	public void iShouldGetTheFollowingIssuePermitResponse ( PermitTicket expectedPermitTicket) {
//		assertThat ( this.scenarioContext.getIssuedPermitTicket(), is(expectedPermitTicket) );
//	}
		
	
	@DataTableType
	public PermitRequest permitRequestEntry ( Map<String, String> dataTableEntry ) {

		LocalDateTime currentDateTime = LocalDateTime.parse ( dataTableEntry.get("current date time"), DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss") );
		Clock clockWithCurrentDateTime = Clock.fixed ( currentDateTime.toInstant(ZoneOffset.UTC), ZoneOffset.UTC );

		LocalDateTime endingDateTime = LocalDateTime.parse ( dataTableEntry.get("ending date time"), DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm") );

		PermitRequest permitRequest = new PermitRequest();
		permitRequest.setClock(clockWithCurrentDateTime);
		permitRequest.setCarPlate(dataTableEntry.get("car plate"));
		permitRequest.setRateName(dataTableEntry.get("rate name"));
		permitRequest.setEndingDateTime(endingDateTime);
		permitRequest.setPaymentCardNumber(dataTableEntry.get("payment card number"));
		
		return permitRequest;
	}

	
	@DataTableType
	public PermitTicket permitTicketEntry ( Map<String, String> dataTableEntry ) {

		LocalDateTime startingDateTime = LocalDateTime.parse ( dataTableEntry.get("starting date time"), DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm") );
		LocalDateTime endingDateTime = LocalDateTime.parse ( dataTableEntry.get("ending date time"), DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm") );
		
		PermitTicket permitTicket = new PermitTicket();
		permitTicket.setCode(dataTableEntry.get("code"));
		permitTicket.setCarPlate(dataTableEntry.get("car plate"));
		permitTicket.setStartingDateTime(startingDateTime);
		permitTicket.setEndingDateTime(endingDateTime);
		permitTicket.setRateName(dataTableEntry.get("rate name"));
		permitTicket.setPrice(new BigDecimal(dataTableEntry.get("price")));
		
		return permitTicket;
	}

	
	
//
//
//	@Given("no permit repository is present")
//	public void noPermitRepositoryIsPresent() {
//		this.scenarioContext.setNoPermitRepositoryPresent(true);
//	}
//




//	@When("I do the following permit issuing request:")
//	public void iDoTheFollowingPermitIssuingRequest ( PermitRequest permitRequest ) {
//		ForParkingCars forParkingCars = DriverPortBuilder.getInstance().forParkingCars ( this.scenarioContext.rateRepository(), this.scenarioContext.permitRepository(), this.scenarioContext.paymentRecipient() );
//		PermitTicket permitTicket = forParkingCars.issuePermit ( this.scenarioContext.clockWithCurrentDateTime(), permitRequest );
//		this.scenarioContext.setIssuedPermitTicket(permitTicket);
//	}
//
//	@Then("I should get the following permit ticket:")
//	public void iShouldGetTheFollowingPermitTicket ( PermitTicket expectedPermitTicket ) {
//		assertThat ( this.scenarioContext.issuedPermitTicket(), is(expectedPermitTicket) );
//	}
//
//	@Then("the following permit ticket should have been stored:")
//	public void theFollowingPermitTicketShouldHaveBeenStored ( PermitTicket expectedPermitTicket ) {
//		PermitTicket storedPermitTicket = this.scenarioContext.permitRepository().findByCode ( expectedPermitTicket.getCode() );
//		assertThat(storedPermitTicket,is(expectedPermitTicket));
//	}
//	
//	@DataTableType
//    public PermitRequest permitRequestEntry ( Map<String, String> dataTableEntry ) {
//		
//		LocalDateTime endingDateTime = LocalDateTime.parse ( dataTableEntry.get("endingDateTime"), DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm") );
//
//		YearMonth paymentCardExpirationDate = YearMonth.parse ( dataTableEntry.get("paymentCardExpirationDate"), DateTimeFormatter.ofPattern("yyyy/MM"));
//		PaymentCardData paymentCard = new PaymentCardData();
//		paymentCard.setNumber(dataTableEntry.get("paymentCardNumber"));
//		paymentCard.setCvv(dataTableEntry.get("paymentCardCvv"));
//		paymentCard.setExpirationDate(paymentCardExpirationDate);
//
//		PermitRequest permitRequest = new PermitRequest();
//		permitRequest.setCarPlate(dataTableEntry.get("carPlate"));
//		permitRequest.setRateName(dataTableEntry.get("rateName"));
//		permitRequest.setEndingDateTime(endingDateTime);
//		permitRequest.setPaymentCard(paymentCard);
//		
//		return permitRequest;
//    }
//
//	
//	@DataTableType
//    public PermitTicket permitTicketEntry ( Map<String, String> dataTableEntry ) {
//
//		LocalDateTime startingDateTime = LocalDateTime.parse ( dataTableEntry.get("startingDateTime"), DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm") );
//		LocalDateTime endingDateTime = LocalDateTime.parse ( dataTableEntry.get("endingDateTime"), DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm") );
//
//		MoneyData price = new MoneyData();
//		price.setAmount ( new BigDecimal(dataTableEntry.get("priceAmount")) );
//		price.setCurrencyCode ( dataTableEntry.get("priceCurrencyCode") );
//		
//		PermitTicket permitTicket = new PermitTicket();
//		permitTicket.setCode(dataTableEntry.get("code"));
//		permitTicket.setCarPlate(dataTableEntry.get("carPlate"));
//		permitTicket.setStartingDateTime(startingDateTime);
//		permitTicket.setEndingDateTime(endingDateTime);
//		permitTicket.setRateName(dataTableEntry.get("rateName"));
//		permitTicket.setPrice(price);
//		
//		return permitTicket;
//	}
	
}
