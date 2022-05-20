package io.github.jmgarridopaz.bluezone.hexagon;

import java.math.BigDecimal;

/**
 * Exception to be thrown during the purchasing of a parking ticket,
 * when the available money in the wallet associated to the car isn't enough for paying the purchase amount.
 */
public class NotEnoughMoneyException extends RuntimeException {

    private BigDecimal availableAmount;
    private BigDecimal requestedAmount;

    public NotEnoughMoneyException ( BigDecimal availableAmount, BigDecimal requestedAmount ) {
        super("There isn't enough money in the wallet. Available: "+availableAmount+"€. Requested: "+requestedAmount+"€");
        this.availableAmount = availableAmount;
        this.requestedAmount = requestedAmount;
    }

}
