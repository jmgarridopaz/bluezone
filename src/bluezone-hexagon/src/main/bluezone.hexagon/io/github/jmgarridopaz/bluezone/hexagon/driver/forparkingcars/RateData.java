package io.github.jmgarridopaz.bluezone.hexagon.driver.forparkingcars;

import java.util.Objects;


public class RateData {
	
	private String			name;
	private MoneyDto		costPerHour;
	private int				minMinutesAllowed;
	private int				maxMinutesAllowed;
	private TimeTableDto	timetable;

	
	public RateData() {}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public MoneyDto getCostPerHour() {
		return costPerHour;
	}

	public void setCostPerHour(MoneyDto costPerHour) {
		this.costPerHour = costPerHour;
	}


	public int getMinMinutesAllowed() {
		return minMinutesAllowed;
	}

	public void setMinMinutesAllowed(int minMinutesAllowed) {
		this.minMinutesAllowed = minMinutesAllowed;
	}


	public int getMaxMinutesAllowed() {
		return maxMinutesAllowed;
	}

	public void setMaxMinutesAllowed(int maxMinutesAllowed) {
		this.maxMinutesAllowed = maxMinutesAllowed;
	}


	public TimeTableDto getTimetable() {
		return timetable;
	}

	public void setTimetable(TimeTableDto timetable) {
		this.timetable = timetable;
	}


	@Override
	public int hashCode() {
		return Objects.hash ( this.name, this.costPerHour, Integer.valueOf(this.minMinutesAllowed), Integer.valueOf(this.maxMinutesAllowed), this.timetable );
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ( obj==null ) {
			return false;
		}
		if (!(obj instanceof RateData)) {
			return false;
		}
		RateData other = (RateData) obj;		
		return	Objects.equals(this.name, other.name) &&
				Objects.equals(this.costPerHour, other.costPerHour) &&
				Objects.equals(Integer.valueOf(this.minMinutesAllowed),Integer.valueOf(other.minMinutesAllowed)) &&
				Objects.equals(Integer.valueOf(this.maxMinutesAllowed),Integer.valueOf(other.maxMinutesAllowed)) &&
				Objects.equals(this.timetable, other.timetable);
	}


	@Override
	public String toString() {
		return String.format (
				"RateData [name=%s, costPerHour=%s, minMinutesAllowed=%s, maxMinutesAllowed=%s, timetable=%s]",
				name, costPerHour, minMinutesAllowed, maxMinutesAllowed, timetable);
	}
	
}
