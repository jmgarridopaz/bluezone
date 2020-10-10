package io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars;

import java.math.BigDecimal;
import java.util.Objects;

public class MoneyDto {

	private BigDecimal amount;
	private String currencySymbol;
	
	public MoneyDto() {}


	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}


	@Override
	public int hashCode() {
		return Objects.hash(amount,currencySymbol);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ( obj == null ) {
			return false;
		}
		if (!(obj instanceof MoneyDto)) {
			return false;
		}
		MoneyDto other = (MoneyDto) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(currencySymbol, other.currencySymbol);
	}

	@Override
	public String toString() {
		return String.format("MoneyDto [amount=%s, currencySymbol=%s]", amount, currencySymbol);
	}
	
}
