package io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.implementation.hardcoded;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.MoneyDto;
import io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.RateData;
import io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.TimeIntervalDto;
import io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.TimeTableDto;


final class HardCodedBlueZoneRate {
	
	private static final String		NAME							= "BLUE_ZONE";
	private static final BigDecimal	COST_PER_HOUR_AMOUNT			= new BigDecimal("0.85");
	private static final String		COST_PER_HOUR_CURRENCY_SYMBOL	= "€";
	private static final int		MIN_MINUTES_ALLOWED				= 35;
	private static final int		MAX_MINUTES_ALLOWED				= 120;
		
	private HardCodedBlueZoneRate() {}

	
	static RateData get() {		
		RateData blueZoneRate				= new RateData();
		blueZoneRate.setName				(NAME);
		blueZoneRate.setCostPerHour			(costPerHour());
		blueZoneRate.setMinMinutesAllowed	(MIN_MINUTES_ALLOWED);
		blueZoneRate.setMaxMinutesAllowed	(MAX_MINUTES_ALLOWED);
		blueZoneRate.setTimetable			(timeTable());
		return blueZoneRate;
	}

	
	private static MoneyDto costPerHour() {
		MoneyDto costPerHour			= new MoneyDto();
		costPerHour.setAmount			(COST_PER_HOUR_AMOUNT);
		costPerHour.setCurrencySymbol	(COST_PER_HOUR_CURRENCY_SYMBOL);
		return costPerHour;
	}

	
	private static TimeTableDto timeTable() {
		TimeTableDto timeTable = new TimeTableDto();
		timeTable.setIntervalsByDayOfWeek (
											Map.of
											(
											DayOfWeek.MONDAY,		List.of(_0900_1400(), _1700_2000()),
											DayOfWeek.TUESDAY,		List.of(_0900_1400(), _1700_2000()),
											DayOfWeek.WEDNESDAY,	List.of(_0900_1400(), _1700_2000()),
											DayOfWeek.THURSDAY,		List.of(_0900_1400(), _1700_2000()),
											DayOfWeek.FRIDAY,		List.of(_0900_1400(), _1700_2000()),
											DayOfWeek.SATURDAY,		List.of(_1000_1400()),
											DayOfWeek.SUNDAY,		List.of()
											)
		);		
		return timeTable;
	}


	private static TimeIntervalDto _0900_1400() {
		TimeIntervalDto _0900_1400 = new TimeIntervalDto();
		_0900_1400.setMinTime(LocalTime.of(9,0));
		_0900_1400.setMaxTime(LocalTime.of(14,0));
		return _0900_1400;
	}

	
	private static TimeIntervalDto _1700_2000() {
		TimeIntervalDto _1700_2000 = new TimeIntervalDto();
		_1700_2000.setMinTime(LocalTime.of(17,0));
		_1700_2000.setMaxTime(LocalTime.of(20,0));
		return _1700_2000;
	}
	
	
	private static TimeIntervalDto _1000_1400() {
		TimeIntervalDto _1000_1400 = new TimeIntervalDto();
		_1000_1400.setMinTime(LocalTime.of(10,0));
		_1000_1400.setMaxTime(LocalTime.of(14,0));
		return _1000_1400;
	}
	
}
