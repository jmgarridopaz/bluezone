package io.github.jmgarridopaz.bluezone.hexagon;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;


public class TimeTableDto {

	private Map<DayOfWeek,List<TimeIntervalDto>> intervalsByDayOfWeek;
		
	public TimeTableDto () {}
	
	
	public Map<DayOfWeek, List<TimeIntervalDto>> getIntervalsByDayOfWeek() {
		return intervalsByDayOfWeek;
	}

	public void setIntervalsByDayOfWeek(Map<DayOfWeek, List<TimeIntervalDto>> intervalsByDayOfWeek) {
		this.intervalsByDayOfWeek = intervalsByDayOfWeek;
	}

	
	@Override
	public int hashCode() {
		return this.intervalsByDayOfWeek.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null ) {
			return false;
		}
		if (!(obj instanceof TimeTableDto)) {
			return false;
		}
		TimeTableDto other = (TimeTableDto) obj;
		return this.intervalsByDayOfWeek.equals ( other.intervalsByDayOfWeek );
	}
	
	@Override
	public String toString() {
		return String.format("TimeTableDto [%s]", this.intervalsByDayOfWeek );
	}
	
}
