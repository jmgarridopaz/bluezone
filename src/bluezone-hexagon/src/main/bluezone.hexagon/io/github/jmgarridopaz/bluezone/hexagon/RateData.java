package io.github.jmgarridopaz.bluezone.hexagon;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class RateData {
	
	private String			name;
	private MoneyData		costPerHour;
	private int				minMinutesAllowed;
	private int				maxMinutesAllowed;
	private TimeTableData	timetable;
	
}
