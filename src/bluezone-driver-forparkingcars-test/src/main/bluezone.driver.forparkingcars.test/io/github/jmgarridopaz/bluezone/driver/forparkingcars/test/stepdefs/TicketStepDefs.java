package io.github.jmgarridopaz.bluezone.driver.forparkingcars.test.stepdefs;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.jmgarridopaz.bluezone.hexagon.*;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class TicketStepDefs {

    private final ScenarioContext scenarioContext;

    public TicketStepDefs(ScenarioContext scenarioContext ) {
        this.scenarioContext = scenarioContext;
    }

    @DataTableType
    public Ticket ticketEntry ( Map<String, String> row ) {
        String code = row.get("code");
        String carPlate = row.get("carPlate");
        String rateName = row.get("rateName");
        LocalDateTime startingDateTime = LocalDateTime.parse ( row.get("startingDateTime"), DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm") );
        LocalDateTime endingDateTime = LocalDateTime.parse ( row.get("endingDateTime"), DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm") );
        BigDecimal price = new BigDecimal(row.get("price"));
        return new Ticket(code,carPlate,rateName,startingDateTime,endingDateTime,price);
    }

    @DataTableType
    public PurchaseTicketRequest purchaseTicketRequestEntry ( Map<String, String> row ) {
        String carPlate = row.get("carPlate");
        String rateName = row.get("rateName");
        LocalDateTime currentDateTime = LocalDateTime.parse ( row.get("clock"), DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm") );
        Clock clock = Clock.fixed(currentDateTime.toInstant(ZoneOffset.UTC),ZoneOffset.UTC);
        BigDecimal amount = new BigDecimal(row.get("amount"));
        String paymentCard = row.get("paymentCard");
        return new PurchaseTicketRequest ( carPlate, rateName, clock, amount, paymentCard );
    }

    @Given("there is the following ticket at ticket repository:")
    public void thereIsTheFollowingTicketAtTicketRepository ( List<Ticket> tickets ) {
        Ticket ticket = tickets.get(0);
        this.scenarioContext.appConfigurator().createTicket(ticket);
    }

    @Given("there is no ticket with code {string} at ticket repository")
    public void thereIsNoTicketWithCodeAtTicketRepository ( String ticketCode ) {
        this.scenarioContext.appConfigurator().eraseTicket(ticketCode);
    }

    @Given("next available ticket code is {string}")
    public void nextAvailableTicketCodeIs(String ticketCode) {
        this.scenarioContext.appConfigurator().setNextTicketCodeToReturn(ticketCode);
    }

    @When("I ask for getting the ticket with code {string}")
    public void iAskForGettingTheTicketWithCode(String ticketCode) {
        Ticket ticket = this.scenarioContext.carParker().getTicket(ticketCode);
        this.scenarioContext.setCurrentTicketWithCode ( ticket );
    }

    @When("I do the following purchase ticket request:")
    public void iDoTheFollowingPurchaseTicketRequest ( PurchaseTicketRequest purchaseTicketRequest ) {
        try {
            String ticketCode = this.scenarioContext.carParker().purchaseTicket(purchaseTicketRequest);
            this.scenarioContext.setPurchasedTicketCode(ticketCode);
        } catch ( PayErrorException payErrorException ) {
            this.scenarioContext.setPayErrorException(payErrorException);
        }
    }

    @Then("I should obtain the following ticket:")
    public void iShouldObtainTheFollowingTicket ( List<Ticket> tickets ) {
        Ticket expectedTicketWithCode = tickets.get(0);
        assertThat( this.scenarioContext.currentTicketWithCode(), is(expectedTicketWithCode) );
    }

    @Then("I should obtain no ticket")
    public void iShouldObtainNoTicket() {
        assertThat ( this.scenarioContext.currentTicketWithCode(),is(nullValue()) );
    }

    @Then("I should obtain the ticket code {string}")
    public void iShouldObtainTheTicketCode(String expectedPurchasedTicketCode) {
        assertThat(this.scenarioContext.purchasedTicketCode(),is(expectedPurchasedTicketCode));
    }

    @Then("there should be the following ticket at ticket repository:")
    public void thereShouldBeTheFollowingTicketAtTicketRepository ( Ticket expectedPurchasedTicket ) {
        Ticket ticketAtRepo = this.scenarioContext.carParker().getTicket(expectedPurchasedTicket.getCode());
        assertThat(ticketAtRepo,is(expectedPurchasedTicket));
    }

    @Then("next available ticket code should be {string}")
    public void nextAvailableTicketCodeShouldBe(String expectedNextTicketCode) {
        String currentNextTicketCode = this.scenarioContext.appConfigurator().getNextTicketCodeToReturn();
        assertThat(currentNextTicketCode,is(expectedNextTicketCode));
    }

    @Then("I should obtain no ticket code")
    public void iShouldObtainNoTicketCode() {
        assertThat(this.scenarioContext.purchasedTicketCode(),is(nullValue()));
    }

    @Then("there should be no ticket with code {string} at ticket repository")
    public void thereShouldBeNoTicketWithCodeAtTicketRepository(String ticketCode) {
        Ticket ticketAtRepo = this.scenarioContext.carParker().getTicket(ticketCode);
        assertThat(ticketAtRepo,is(nullValue()));
    }

}
