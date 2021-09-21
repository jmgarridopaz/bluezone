package io.github.jmgarridopaz.bluezone.hexagon;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PermitTicketCode {

	private final static String CAPITAL_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private final String value;

	private PermitTicketCode ( String aString ) {
		this.value = aString;
	}

	public static PermitTicketCode of ( String carPlate, LocalDateTime startingDateTime ) {
		String value = "PT" + valueOfCarPlate (carPlate) + valueOfDateTime (startingDateTime);
		return new PermitTicketCode (value);
	}

	private static String valueOfDateTime ( LocalDateTime aDateTime ) {
		return aDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
	}

	private static String valueOfCarPlate ( String aCarPlate ) {
		return	(
				aCarPlate.substring(0,4) +
				valueOfLetter(aCarPlate.charAt(4)) +
				valueOfLetter(aCarPlate.charAt(5)) +
				valueOfLetter(aCarPlate.charAt(6))
				);
	}

	private static String valueOfLetter (char aLetter) {
		String value = String.valueOf ( CAPITAL_LETTERS.indexOf(aLetter) );
		if ( value.length()==1 ) {
			value = ("0" + value);
		}
		return value;
	}


	public String value() {
		return this.value;
	}

}
