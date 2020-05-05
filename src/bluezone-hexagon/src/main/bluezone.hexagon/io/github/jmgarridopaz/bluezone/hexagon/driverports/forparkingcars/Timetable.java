package io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars;

import java.util.Objects;

public class Timetable {
	
	private final String monday;
	private final String tuesday;
	private final String wednesday;
	private final String thursday;
	private final String friday;
	private final String saturday;
	private final String sunday;
	
	
	public Timetable ( String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday ) {
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.sunday = sunday;
	}

	public String monday() {
		return this.monday;
	}
	public String tuesday() {
		return this.tuesday;
	}
	public String wednesday() {
		return this.wednesday;
	}
	public String thursday() {
		return this.thursday;
	}
	public String friday() {
		return this.friday;
	}
	public String saturday() {
		return this.saturday;
	}
	public String sunday() {
		return this.sunday;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(this.monday,this.tuesday,this.wednesday,this.thursday,this.friday,this.saturday,this.sunday);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ( obj==null ) {
			return false;
		}
		if (!(obj instanceof Timetable)) {
			return false;
		}
		Timetable other = (Timetable) obj;
		
		return	Objects.equals(this.monday, other.monday()) &&
				Objects.equals(this.tuesday, other.tuesday()) &&
				Objects.equals(this.wednesday, other.wednesday()) &&
				Objects.equals(this.thursday, other.thursday()) &&
				Objects.equals(this.friday, other.friday()) &&
				Objects.equals(this.saturday, other.saturday()) &&
				Objects.equals(this.sunday, other.sunday());
	}
	
}
