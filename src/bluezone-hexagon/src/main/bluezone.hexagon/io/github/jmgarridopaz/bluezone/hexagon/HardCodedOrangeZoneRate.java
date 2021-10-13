package io.github.jmgarridopaz.bluezone.hexagon;

import java.math.BigDecimal;


public final class HardCodedOrangeZoneRate {
	
	private static final String		NAME				= "ORANGE_ZONE";
	private static final BigDecimal	AMOUNT_PER_HOUR		= new BigDecimal("0.80");
	private static final int		MIN_MINUTES_ALLOWED	= 35;
	private static final int		MAX_MINUTES_ALLOWED	= 180;
		
	private HardCodedOrangeZoneRate() {}

	
	public static RateData get() {
		RateData orangeZoneRate				= new RateData();
		orangeZoneRate.setName				(NAME);
		orangeZoneRate.setAmountPerHour		(AMOUNT_PER_HOUR);
		orangeZoneRate.setMinMinutesAllowed	(MIN_MINUTES_ALLOWED);
		orangeZoneRate.setMaxMinutesAllowed	(MAX_MINUTES_ALLOWED);
		return orangeZoneRate;
	}

}
