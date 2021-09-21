package io.github.jmgarridopaz.bluezone.hexagon;

import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;


public final class Money {
	
	private BigDecimal amount;
	private final Currency currency;
	private final RoundingMode rounding;

	
	private Money(BigDecimal amount, Currency currency, RoundingMode roundingStyle) {
		if (amount == null) {
			throw new IllegalArgumentException("Amount cannot be null");
		}
		if (currency == null) {
			throw new IllegalArgumentException("Currency cannot be null");
		}
		if (roundingStyle == null) {
			throw new IllegalArgumentException("RoundingStyle cannot be null");
		}
		this.amount = amount.setScale ( currency.getDefaultFractionDigits(), roundingStyle );
		this.currency = currency;
		this.rounding = roundingStyle;
	}

	
	public static Money fromData ( MoneyData moneyData ) {
		return new Money
						(
						moneyData.getAmount(),
						Currency.getInstance(moneyData.getCurrencyCode()),
						RoundingMode.HALF_UP
						);
	}
	
	public MoneyData toData() {
		MoneyData moneyData = new MoneyData();
		moneyData.setAmount(this.amount);
		moneyData.setCurrencyCode(this.currency.getCurrencyCode());
		return moneyData;
	}
	
	
	public BigDecimal amount() {
		return this.amount;
	}

	public Currency currency() {
		return this.currency;
	}

	public RoundingMode roundingStyle() {
		return this.rounding;
	}


	public Money multiply ( double factor ) {
		BigDecimal factorAsBigDecimal = new BigDecimal ( Double.toString(factor) );
		BigDecimal newAmount = amount.multiply ( factorAsBigDecimal );
		return new Money ( newAmount, this.currency, this.rounding );
	}

	public Money div ( double divisor ) {
		BigDecimal divisorAsBigDecimal = new BigDecimal ( Double.toString(divisor) );
		BigDecimal newAmount = this.amount.divide ( divisorAsBigDecimal, this.rounding );
		return new Money ( newAmount, this.currency, this.rounding);
	}


	@Override
	public boolean equals ( Object aThat ) {
		if (aThat == null) {
			return false;
		}
		if (this == aThat) {
			return true;
		}
		if (!(aThat instanceof Money)) {
			return false;
		}
		Money that = (Money) aThat;
		return	(
				Objects.equals(this.amount,that.amount)
				&&
				Objects.equals(this.currency,that.currency)
				&&
				Objects.equals(this.rounding,that.rounding)
				);
	}

	
	@Override
	public int hashCode() {
		return Objects.hash ( this.amount, this.currency, this.rounding );
	}

	@Override
	public String toString() {
		return this.amount.toPlainString() + " " + this.currency.getSymbol();
	}

}
