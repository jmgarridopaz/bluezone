package io.github.jmgarridopaz.bluezone.driver.forparkingcars.test.stepdefs;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.jmgarridopaz.bluezone.hexagon.NotEnoughMoneyException;
import io.github.jmgarridopaz.bluezone.hexagon.PurchaseTicketRequest;
import io.github.jmgarridopaz.bluezone.hexagon.Rate;
import io.github.jmgarridopaz.bluezone.hexagon.Ticket;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class AllStepDefs {

    private final ScenarioContext scenarioContext;

    public AllStepDefs ( ScenarioContext scenarioContext ) {
        this.scenarioContext = scenarioContext;
    }

    @DataTableType
    public Rate rateEntry ( Map<String, String> row ) {
        String name = row.get("name");
        BigDecimal amountPerHour = new BigDecimal(row.get("amountPerHour"));
        return new Rate(name,amountPerHour);
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
        return new PurchaseTicketRequest ( carPlate, rateName, clock, amount );
    }


    @Given("there are the following rates at rate repository:")
    public void thereAreTheFollowingRatesAtRateRepository ( List<Rate> rates ) {
        this.scenarioContext.appConfigurator().createRates ( rates );
    }

    @When("I ask for getting all rates by name")
    public void iAskForGettingAllRatesByName() {
        Map<String,Rate> ratesByName = this.scenarioContext.carParker().getAllRatesByName();
        this.scenarioContext.setCurrentRatesByName ( ratesByName );
    }

    @Then("I should obtain the following rates indexed by name:")
    public void iShouldObtainTheFollowingRatesIndexedByName ( Map<String, Rate> expectedRatesByName ) {
        assertThat(this.scenarioContext.currentRatesByName(),is(expectedRatesByName));
    }

    @Given("there is the following ticket at ticket repository:")
    public void thereIsTheFollowingTicketAtTicketRepository ( List<Ticket> tickets ) {
        Ticket ticket = tickets.get(0);
        this.scenarioContext.appConfigurator().createTicket(ticket);
    }

    @When("I ask for getting the ticket with code {string}")
    public void iAskForGettingTheTicketWithCode(String ticketCode) {
        Ticket ticket = this.scenarioContext.carParker().getTicket(ticketCode);
        this.scenarioContext.setCurrentTicketWithCode ( ticket );
    }

    @Then("I should obtain the following ticket:")
    public void iShouldObtainTheFollowingTicket ( List<Ticket> tickets ) {
        Ticket expectedTicketWithCode = tickets.get(0);
        assertThat( this.scenarioContext.currentTicketWithCode(), is(expectedTicketWithCode) );
    }

    @Given("there is no ticket with code {string} at ticket repository")
    public void thereIsNoTicketWithCodeAtTicketRepository ( String ticketCode ) {
        this.scenarioContext.appConfigurator().eraseTicket(ticketCode);
    }

    @Then("I should obtain no ticket")
    public void iShouldObtainNoTicket() {
        assertThat ( this.scenarioContext.currentTicketWithCode(),is(nullValue()) );
    }

    @Given("next available ticket code is {string}")
    public void nextAvailableTicketCodeIs(String ticketCode) {
        this.scenarioContext.appConfigurator().setNextTicketCodeToReturn(ticketCode);
    }

    @Given("the wallet owned by the car {string} has {string} euros")
    public void theWalletOwnedByTheCarHasEuros(String carPlate, String amount) {
        this.scenarioContext.appConfigurator().createWalletOfOwnerWithAmount(carPlate,new BigDecimal(amount));
    }

    @When("I do the following purchase ticket request:")
    public void iDoTheFollowingPurchaseTicketRequest ( PurchaseTicketRequest purchaseTicketRequest ) {
        try {
            String ticketCode = this.scenarioContext.carParker().purchaseTicket(purchaseTicketRequest);
            this.scenarioContext.setPurchasedTicketCode(ticketCode);
        } catch ( NotEnoughMoneyException notEnoughMoneyException ) {
            this.scenarioContext.setNotEnoughMoneyException(notEnoughMoneyException);
        }
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

    @Then("the wallet owned by the car {string} should have {string} euros")
    public void theWalletOwnedByTheCarShouldHaveEuros(String carPlate, String amount) {
        BigDecimal currentEurosInWallet = this.scenarioContext.appConfigurator().getEurosInWallet ( carPlate );
        BigDecimal expectedEurosInWallet = new BigDecimal(amount);
        assertThat(currentEurosInWallet,comparesEqualTo(expectedEurosInWallet));
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

    @Then("a NotEnoughMoneyException with {string} euros available and {string} euros requested should have been thrown")
    public void aNotEnoughMoneyExceptionWithEurosAvailableAndEurosRequestedShouldHaveBeenThrown(String expectedAvailableAmount, String expectedRequestedAmount) {
        NotEnoughMoneyException notEnoughMoneyExceptionThrown = this.scenarioContext.notEnoughMoneyException();
        NotEnoughMoneyException expectedNotEnoughMoneyException = new NotEnoughMoneyException
                                                                        (
                                                                        new BigDecimal(expectedAvailableAmount),
                                                                        new BigDecimal(expectedRequestedAmount)
                                                                        );
        assertThat(notEnoughMoneyExceptionThrown,is(expectedNotEnoughMoneyException));
    }

}
