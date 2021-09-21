package io.github.jmgarridopaz.bluezone.hexagon;


import java.math.BigDecimal;


public final class HardCodedGreenZoneRate {
	
	private static final String		NAME						= "GREEN_ZONE";
	private static final BigDecimal	COST_PER_HOUR_AMOUNT		= new BigDecimal("0.65");
	private static final String		COST_PER_HOUR_CURRENCY_CODE	= "EUR";
	private static final int		MIN_MINUTES_ALLOWED			= 60;
	private static final int		MAX_MINUTES_ALLOWED			= 180;
		
	private HardCodedGreenZoneRate() {}

	
	public static RateData get() {		
		RateData greenZoneRate				= new RateData();
		greenZoneRate.setName				(NAME);
		greenZoneRate.setCostPerHour		(costPerHour());
		greenZoneRate.setMinMinutesAllowed	(MIN_MINUTES_ALLOWED);
		greenZoneRate.setMaxMinutesAllowed	(MAX_MINUTES_ALLOWED);
		greenZoneRate.setTimetable			(timeTable());
		return greenZoneRate;
	}

	
	private static MoneyData costPerHour() {
		MoneyData costPerHour		= new MoneyData();
		costPerHour.setAmount		(COST_PER_HOUR_AMOUNT);
		costPerHour.setCurrencyCode	(COST_PER_HOUR_CURRENCY_CODE);		
		return costPerHour;
	}

	
	private static TimeTableData timeTable() {
		TimeTableData timeTable = new TimeTableData();
		timeTable.setMonday(new String[]{"08:00","22:00"});
		timeTable.setTuesday(new String[]{"08:00","22:00"});
		timeTable.setWednesday(new String[]{"08:00","22:00"});
		timeTable.setThursday(new String[]{"08:00","22:00"});
		timeTable.setFriday(new String[]{"08:00","22:00"});
		timeTable.setSaturday(new String[]{"08:00","22:00"});
		timeTable.setSunday(new String[]{"08:00","22:00"});
		return timeTable;
	}

}
