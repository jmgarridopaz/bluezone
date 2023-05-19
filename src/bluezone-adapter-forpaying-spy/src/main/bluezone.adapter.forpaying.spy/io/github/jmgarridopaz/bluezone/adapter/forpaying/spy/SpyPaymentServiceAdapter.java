package io.github.jmgarridopaz.bluezone.adapter.forpaying.spy;

import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forpaying.ForPaying;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forpaying.PayErrorException;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forpaying.PayRequest;
import io.github.jmgarridopaz.lib.portsadapters.Adapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Driven adapter that implements "forpaying" port with a "spy" test double.
 */
@Adapter(name="test-double")
public class SpyPaymentServiceAdapter implements ForPaying {

    private List<PayRequest> paymentSpool;
    private int payErrorGenerationPercentage;


    public SpyPaymentServiceAdapter() {
        this.paymentSpool = new ArrayList<PayRequest>();
        setPayErrorGenerationPercentage(0);
    }

    @Override
    public void setPayErrorGenerationPercentage ( int percent ) {
        this.payErrorGenerationPercentage = validatePercent(percent);
    }

    @Override
    public PayRequest lastPayRequest() {
        int spoolSize = this.paymentSpool.size();
        if ( spoolSize == 0 ) {
            return null;
        }
        return this.paymentSpool.get(spoolSize-1);
    }

    @Override
    public void pay ( PayRequest payRequest ) throws PayErrorException {
        this.paymentSpool.add(payRequest);
        throwPayErrorExceptionRandomly();
    }

    private void throwPayErrorExceptionRandomly() {
        int numberBetween1And100 = (new Random()).nextInt(100) + 1;
        if ( numberBetween1And100 <= this.payErrorGenerationPercentage ) {
            throw new PayErrorException("Payment failed");
        }
    }

    private int validatePercent(int percent) {
        if ( percent < 0 ) {
            return  0;
        }
        if ( percent > 100 ) {
            return  100;
        }
        return percent;
    }

}

