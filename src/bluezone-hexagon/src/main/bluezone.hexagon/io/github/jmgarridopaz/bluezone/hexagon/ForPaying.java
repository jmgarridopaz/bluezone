package io.github.jmgarridopaz.bluezone.hexagon;

import java.math.BigDecimal;

/**
 * DRIVEN PORT
 */
public interface ForPaying {

    public BigDecimal getMoneyInWallet ( String walletOwner );

    public void payWithWallet ( String walletOwner, BigDecimal amount );

}
