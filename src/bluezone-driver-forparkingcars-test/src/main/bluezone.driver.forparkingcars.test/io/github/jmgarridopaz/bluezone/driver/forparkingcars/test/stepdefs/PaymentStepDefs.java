package io.github.jmgarridopaz.bluezone.driver.forparkingcars.test.stepdefs;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.github.jmgarridopaz.bluezone.hexagon.PayRequest;
import java.math.BigDecimal;
import java.util.Map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;


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

    @Then("the following pay request should have been done to payment service:")
    public void theFollowingPayRequestShouldHaveBeenDoneToPaymentService ( PayRequest expectedPayRequest ) {
        PayRequest lastPayRequest = this.scenarioContext.appConfigurator().getLastPayRequestDone();
        assertThat(lastPayRequest,is(expectedPayRequest));
    }

    @Then("a PayErrorException should have been thrown")
    public void aPayErrorExceptionShouldHaveBeenThrown() {
        assertThat(this.scenarioContext.payErrorException(),is(notNullValue()));
    }

}
