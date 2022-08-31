package io.github.jmgarridopaz.bluezone.adapter.forpaying.spy;

import io.github.jmgarridopaz.bluezone.hexagon.ForPaying;
import io.github.jmgarridopaz.bluezone.hexagon.PayErrorException;
import io.github.jmgarridopaz.bluezone.hexagon.PayRequest;
import io.github.jmgarridopaz.lib.portsadapters.Adapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Driven adapter that implements "forpaying" port with a "spy" test double.
 */
@Adapter(name="test-double")
public class SpyPaymentServiceAdapter implements ForPaying {

    private static final String VALID_PAYMENT_CARD = "5200828282828210";

    private List<PayRequest> paymentSpool;

    public SpyPaymentServiceAdapter() {
        this.paymentSpool = new ArrayList<PayRequest>();
    }

    @Override
    public void pay ( PayRequest payRequest ) throws PayErrorException {
        this.paymentSpool.add(payRequest);
        if ( ! payRequest.getPaymentCard().equals(VALID_PAYMENT_CARD) ) {
            throw new PayErrorException("Invalid card. Payment failed.");
        }
    }

    @Override
    public PayRequest lastPayRequest() {
        int spoolSize = this.paymentSpool.size();
        if ( spoolSize == 0 ) {
            return null;
        }
        return this.paymentSpool.get(spoolSize-1);
    }

}

