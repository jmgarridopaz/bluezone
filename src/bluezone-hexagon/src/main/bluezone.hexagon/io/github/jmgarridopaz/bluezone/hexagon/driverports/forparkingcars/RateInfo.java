package io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars;

import java.util.Objects;

/**
 * DTO class with information about a rate:
 * 
 * 		name					Unique identifier of the rate
 * 		costPerHour				Amount of money to pay for parking the car for one hour. Format example: "1.70 €"
 * 		minutesAllowedInterval	Minimum and maximum number of minutes allowed to pay for when requesting a permit. Format example: "30-60"
 * 		timetable				Time intervals when the rate applies, depending on the day of the week. @see Timetable
 */
public final class RateInfo {
	
	private final String	name;
	private final String	costPerHour;
	private final String	minutesAllowedInterval;
	private final Timetable	timetable;

	
	public RateInfo ( String name, String costPerHour, String minutesAllowedInterval, Timetable timetable ) {
		this.name = name;
		this.costPerHour = costPerHour;
		this.minutesAllowedInterval = minutesAllowedInterval;
		this.timetable = timetable;
	}
	
	
	public String name() {
		return this.name;
	}

	public String costPerHour() {
		return this.costPerHour;
	}

	public String minutesAllowedInterval() {
		return this.minutesAllowedInterval;
	}

	public Timetable timetable() {
		return this.timetable;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash ( this.name, this.costPerHour, this.minutesAllowedInterval, this.timetable );
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ( obj==null ) {
			return false;
		}
		if (!(obj instanceof RateInfo)) {
			return false;
		}
		RateInfo other = (RateInfo) obj;
		
		return	Objects.equals(this.name, other.name()) &&
				Objects.equals(this.costPerHour, other.costPerHour()) &&
				Objects.equals(this.minutesAllowedInterval, other.minutesAllowedInterval()) &&
				Objects.equals(this.timetable, other.timetable);
	}
	
}
