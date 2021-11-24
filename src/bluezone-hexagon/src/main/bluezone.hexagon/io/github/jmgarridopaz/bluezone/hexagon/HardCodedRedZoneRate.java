package io.github.jmgarridopaz.bluezone.hexagon;

import java.math.BigDecimal;


public final class HardCodedRedZoneRate {
	
	private static final String		NAME				= "RED_ZONE";
	private static final BigDecimal	AMOUNT_PER_HOUR		= new BigDecimal("1.25");
	private static final int		MIN_MINUTES_ALLOWED	= 30;
	private static final int		MAX_MINUTES_ALLOWED	= 60;
		
	private HardCodedRedZoneRate() {}

	
	public static RateData get() {		
		RateData greenZoneRate				= new RateData();
		greenZoneRate.setName				(NAME);
		greenZoneRate.setAmountPerHour		(AMOUNT_PER_HOUR);
		greenZoneRate.setMinMinutesAllowed	(MIN_MINUTES_ALLOWED);
		greenZoneRate.setMaxMinutesAllowed	(MAX_MINUTES_ALLOWED);
		return greenZoneRate;
	}

}
