package io.github.jmgarridopaz.bluezone.hexagon.forparkingcars;

import java.time.LocalTime;
import java.util.Objects;


public class TimeIntervalDto {

	private LocalTime minTime;
	private LocalTime maxTime;

	
	public TimeIntervalDto() {}

	
	public LocalTime getMinTime() {
		return minTime;
	}

	public void setMinTime(LocalTime minTime) {
		this.minTime = minTime;
	}

	
	public LocalTime getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(LocalTime maxTime) {
		this.maxTime = maxTime;
	}


	@Override
	public int hashCode() {
		return Objects.hash(maxTime, minTime);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof TimeIntervalDto)) {
			return false;
		}
		TimeIntervalDto other = (TimeIntervalDto) obj;
		return Objects.equals(maxTime, other.maxTime) && Objects.equals(minTime, other.minTime);
	}


	@Override
	public String toString() {
		return String.format("TimeIntervalDto [minTime=%s, maxTime=%s]", minTime, maxTime);
	}

}
