package io.github.jmgarridopaz.bluezone.adapter.forpaying.spy;

import io.github.jmgarridopaz.bluezone.hexagon.ForPaying;
import io.github.jmgarridopaz.bluezone.hexagon.NotEnoughMoneyException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Driven adapter that implements "forpaying" port with a "spy" test double.
 */
public class SpyEWalletServiceAdapter implements ForPaying {

    private Map<String,BigDecimal> balanceByWalletOwner;


    public SpyEWalletServiceAdapter() {
        this.balanceByWalletOwner = new HashMap<String,BigDecimal>();
    }

    @Override
    public BigDecimal getMoneyInWallet(String walletOwner) {
        return this.balanceByWalletOwner.get(walletOwner);
    }

    @Override
    public void payWithWallet ( String walletOwner, BigDecimal amount ) {
        BigDecimal availableMoney = this.balanceByWalletOwner.get(walletOwner);
        if ( availableMoney.compareTo(amount) == -1 ) {
            throw new NotEnoughMoneyException(availableMoney,amount);
        }
        this.balanceByWalletOwner.put(walletOwner,availableMoney.subtract(amount));
    }

    @Override
    public void newWallet(String walletOwner, BigDecimal initialAmount) {
        balanceByWalletOwner.put(walletOwner,initialAmount);
    }
}

