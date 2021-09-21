package io.github.jmgarridopaz.bluezone.hexagon;

import java.util.Objects;

public class RateName {

	private static final String PATTERN  = "([A-Z][A-Z_0-9]*[A-Z0-9])|[A-Z]";

	private final String value;
	
	private RateName ( String aString ) {
		this.value = aString;
	}

	public static RateName parse ( String aString ) {
		if ( ! isValid(aString) ) {
			throw new RuntimeException("Invalid rate name format. Valid characters are capital letters, digits and _. Starting with letters, ending with letter or digit.");
		}
		return new RateName(aString);
	}
	
	public String value() {
		return this.value;
	}
	
	private static boolean isValid ( String aString ) {
		if ( aString==null || aString.length()==0 ) {
			return false;
		}
		return aString.matches(PATTERN);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.value);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof RateName)) {
			return false;
		}
		RateName other = (RateName) obj;
		return Objects.equals(this.value, other.value);
	}

	@Override
	public String toString() {
		return String.format("RateName [value=%s]", this.value);
	}

}
