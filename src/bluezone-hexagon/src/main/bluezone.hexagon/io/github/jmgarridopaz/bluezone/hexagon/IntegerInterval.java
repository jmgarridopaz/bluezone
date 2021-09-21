package io.github.jmgarridopaz.bluezone.hexagon;

import java.util.Objects;

public class IntegerInterval {
	
	private final int minValue;
	private final int maxValue;

	private IntegerInterval ( int minValue, int maxValue ) {
		if ( minValue > maxValue ) {
			throw new RuntimeException("min value cannot be greater than max value");
		}
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	public static IntegerInterval of ( int minValue, int maxValue ) {
		return new IntegerInterval  ( minValue, maxValue );
	}

	
	public boolean contains (int anIntValue ) {
		return ( (anIntValue >= this.minValue) && (anIntValue <= this.maxValue) );
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.minValue, this.maxValue);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof IntegerInterval)) {
			return false;
		}
		IntegerInterval other = (IntegerInterval) obj;
		return
				(
				(this.minValue == other.minValue)
				&&
				(this.maxValue == other.maxValue)
				);
	}

	@Override
	public String toString() {
		return String.format("IntegerInterval [minValue=%s, maxValue=%s]", this.minValue, this.maxValue);
	}

}
