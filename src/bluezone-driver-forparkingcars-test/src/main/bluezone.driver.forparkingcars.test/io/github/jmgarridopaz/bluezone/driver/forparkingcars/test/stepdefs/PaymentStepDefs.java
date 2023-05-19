package io.github.jmgarridopaz.bluezone.driver.forparkingcars.test.stepdefs;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forpaying.PayRequest;
import java.math.BigDecimal;
import java.util.Map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class PaymentStepDefs {

    private final ScenarioContext scenarioContext;

    public PaymentStepDefs(ScenarioContext scenarioContext ) {
        this.scenarioContext = scenarioContext;
    }

    @DataTableType
    public PayRequest payRequestEntry ( Map<String, String> row ) {
        String ticketCode = row.get("ticketCode");
        String paymentCard = row.get("paymentCard");
        BigDecimal amount = new BigDecimal(row.get("amount"));
        return new PayRequest ( ticketCode, paymentCard, amount );
    }

    @Given("the payment is not valid")
    public void thePaymentIsNotValid() {
        this.scenarioContext.appConfigurator().setPaymentErrorPercentage(100);
    }

    @Given("the payment is valid")
    public void thePaymentIsValid() {
        this.scenarioContext.appConfigurator().setPaymentErrorPercentage(0);
    }

    @Then("the following pay request should have been done to payment service:")
    public void theFollowingPayRequestShouldHaveBeenDoneToPaymentService ( PayRequest expectedPayRequest ) {
        PayRequest lastPayRequest = this.scenarioContext.appConfigurator().getLastPayRequestDone();
        assertThat(lastPayRequest,is(expectedPayRequest));
    }

    @Then("a PayErrorException should have been thrown")
    public void aPayErrorExceptionShouldHaveBeenThrown() {
        assertThat(this.scenarioContext.payErrorException(),is(notNullValue()));
    }

    @Then("no PayErrorException should have been thrown")
    public void noPayErrorExceptionShouldHaveBeenThrown() {
        assertThat(this.scenarioContext.payErrorException(),is(nullValue()));
    }

}
