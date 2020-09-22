package io.github.jmgarridopaz.bluezone.hexagon.forparkingcars.implementation;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import io.github.jmgarridopaz.bluezone.hexagon.forparkingcars.MoneyDto;
import io.github.jmgarridopaz.bluezone.hexagon.forparkingcars.RateData;
import io.github.jmgarridopaz.bluezone.hexagon.forparkingcars.TimeIntervalDto;
import io.github.jmgarridopaz.bluezone.hexagon.forparkingcars.TimeTableDto;


final class HardCodedGreenZoneRate {
	
	private static final String		NAME							= "GREEN_ZONE";
	private static final BigDecimal	COST_PER_HOUR_AMOUNT			= new BigDecimal("0.65");
	private static final String		COST_PER_HOUR_CURRENCY_SYMBOL	= "€";
	private static final int		MIN_MINUTES_ALLOWED				= 60;
	private static final int		MAX_MINUTES_ALLOWED				= 180;
		
	private HardCodedGreenZoneRate() {}

	
	static RateData get() {		
		RateData greenZoneRate				= new RateData();
		greenZoneRate.setName				(NAME);
		greenZoneRate.setCostPerHour		(costPerHour());
		greenZoneRate.setMinMinutesAllowed	(MIN_MINUTES_ALLOWED);
		greenZoneRate.setMaxMinutesAllowed	(MAX_MINUTES_ALLOWED);
		greenZoneRate.setTimetable			(timeTable());
		return greenZoneRate;
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
											DayOfWeek.MONDAY,		List.of(_0800_2200()),
											DayOfWeek.TUESDAY,		List.of(_0800_2200()),
											DayOfWeek.WEDNESDAY,	List.of(_0800_2200()),
											DayOfWeek.THURSDAY,		List.of(_0800_2200()),
											DayOfWeek.FRIDAY,		List.of(_0800_2200()),
											DayOfWeek.SATURDAY,		List.of(_0800_2200()),
											DayOfWeek.SUNDAY,		List.of(_0800_2200())
											)
		);		
		return timeTable;
	}


	private static TimeIntervalDto _0800_2200() {
		TimeIntervalDto _0800_2200 = new TimeIntervalDto();
		_0800_2200.setMinTime(LocalTime.of(8,0));
		_0800_2200.setMaxTime(LocalTime.of(22,0));
		return _0800_2200;
	}
	
}
