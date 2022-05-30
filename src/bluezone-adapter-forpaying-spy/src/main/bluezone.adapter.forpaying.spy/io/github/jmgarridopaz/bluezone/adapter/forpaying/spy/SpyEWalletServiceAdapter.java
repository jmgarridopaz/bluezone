package io.github.jmgarridopaz.bluezone.adapter.forpaying.spy;

import io.github.jmgarridopaz.bluezone.hexagon.ForPaying;

import java.math.BigDecimal;

/**
 * Driven adapter that implements "forpaying" port with a "spy" test double.
 */
public class SpyEWalletServiceAdapter implements ForPaying {

    @Override
    public BigDecimal getMoneyInWallet(String walletOwner) {
        return null;
    }

    @Override
    public void payWithWallet(String walletOwner, BigDecimal amount) {

    }

    @Override
    public void newWallet(String walletOwner, BigDecimal initialAmount) {

    }
}

