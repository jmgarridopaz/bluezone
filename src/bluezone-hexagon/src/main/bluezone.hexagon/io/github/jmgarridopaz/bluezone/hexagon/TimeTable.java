package io.github.jmgarridopaz.bluezone.hexagon;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TimeTable {

	private Map<DayOfWeek,List<LocalTime>> byDayOfWeek;

	
	private TimeTable ( String[][] weekTable ) {
		if ( (weekTable==null) || (weekTable.length!=DayOfWeek.values().length) ) {
			throw new RuntimeException("You must provide a table for every day of the week");
		}
		this.byDayOfWeek = new HashMap<DayOfWeek, List<LocalTime>>();
		for ( DayOfWeek day : DayOfWeek.values() ) {
			int dayIndex = day.getValue();
			List<LocalTime> dayTable = parse ( weekTable[dayIndex-1] );
			dayTable.sort(null);
			this.byDayOfWeek.put ( day, dayTable );
		}
	}

	
	public static TimeTable fromData ( TimeTableData timeTableData) {
		return new TimeTable
							(
							new String[][]
											{
											timeTableData.getMonday(),
											timeTableData.getTuesday(),
											timeTableData.getWednesday(),
											timeTableData.getThursday(),
											timeTableData.getFriday(),
											timeTableData.getSaturday(),
											timeTableData.getSunday()
											}
							);
	}

	
	public int minutes ( DateTimeInterval aDateTimeInterval ) {
		int result = 0;
		LocalDate aDate = aDateTimeInterval.startingDate();
		while ( ! aDate.isAfter ( aDateTimeInterval.endingDate() ) ) {
			List<DateTimeInterval> tableIntervalsOfDate = tableIntervalsOf(aDate);
			for ( DateTimeInterval tableInterval : tableIntervalsOfDate ) {
				result += aDateTimeInterval.overlappedMinutes ( tableInterval );
			}
			aDate = aDate.plusDays(1);
		}
		return result;
	}

	private List<DateTimeInterval> tableIntervalsOf ( LocalDate aDate ) {
		List<DateTimeInterval> intervals = new ArrayList<DateTimeInterval>();
		List<LocalTime> timeListOfDate = this.byDayOfWeek.get(aDate.getDayOfWeek());
		for ( int index = 0; index < timeListOfDate.size(); index++ ) {
			LocalDateTime startingDateTime = LocalDateTime.of(aDate,timeListOfDate.get(index));
			LocalDateTime endingDateTime = LocalDateTime.of(aDate.plusDays(1), LocalTime.MIDNIGHT);
			if ( (index+1) < timeListOfDate.size() ) {
				endingDateTime = LocalDateTime.of(aDate,timeListOfDate.get(index+1));
			}
			DateTimeInterval interval = DateTimeInterval.of(startingDateTime, endingDateTime);
			intervals.add(interval);
		}
		return intervals;
	}
		
	private List<LocalTime> parse ( String[] anArrayOfString ) {
		List<LocalTime> dayTable = new ArrayList<LocalTime>();
		if ( (anArrayOfString==null) || (anArrayOfString.length==0) ) {
			return dayTable;
		}
		for ( String aString : anArrayOfString ) {
			dayTable.add ( LocalTime.parse(aString) );
		}
		return dayTable;
	}

	@Override
	public int hashCode() {
		return this.byDayOfWeek.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null ) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TimeTable)) {
			return false;
		}
		TimeTable other = (TimeTable) obj;
		return this.byDayOfWeek.equals ( other.byDayOfWeek );
	}
	
	@Override
	public String toString() {
		return String.format("TimeTable [%s]", this.byDayOfWeek );
	}

}
