package io.github.jmgarridopaz.bluezone.hexagon;

import java.math.BigDecimal;


public final class HardCodedBlueZoneRate {
	
	private static final String		NAME							= "BLUE_ZONE";
	private static final BigDecimal	COST_PER_HOUR_AMOUNT			= new BigDecimal("0.85");
	private static final String		COST_PER_HOUR_CURRENCY_CODE		= "EUR";
	private static final int		MIN_MINUTES_ALLOWED				= 35;
	private static final int		MAX_MINUTES_ALLOWED				= 120;
		
	private HardCodedBlueZoneRate() {}

	
	public static RateData get() {		
		RateData blueZoneRate				= new RateData();
		blueZoneRate.setName				(NAME);
		blueZoneRate.setCostPerHour			(costPerHour());
		blueZoneRate.setMinMinutesAllowed	(MIN_MINUTES_ALLOWED);
		blueZoneRate.setMaxMinutesAllowed	(MAX_MINUTES_ALLOWED);
		blueZoneRate.setTimetable			(timeTable());
		return blueZoneRate;
	}

	
	private static MoneyData costPerHour() {
		MoneyData costPerHour			= new MoneyData();
		costPerHour.setAmount			(COST_PER_HOUR_AMOUNT);
		costPerHour.setCurrencyCode		(COST_PER_HOUR_CURRENCY_CODE);
		return costPerHour;
	}

	
	private static TimeTableData timeTable() {
		TimeTableData timeTable = new TimeTableData();
		timeTable.setMonday(new String[]{"09:00","14:00","17:00","20:00"});
		timeTable.setTuesday(new String[]{"09:00","14:00","17:00","20:00"});
		timeTable.setWednesday(new String[]{"09:00","14:00","17:00","20:00"});
		timeTable.setThursday(new String[]{"09:00","14:00","17:00","20:00"});
		timeTable.setFriday(new String[]{"09:00","14:00","17:00","20:00"});
		timeTable.setSaturday(new String[]{"10:00","14:00"});
		timeTable.setSunday(new String[0]);
		return timeTable;
	}

}
