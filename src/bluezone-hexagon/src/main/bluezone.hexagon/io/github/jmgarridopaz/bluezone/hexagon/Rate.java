package io.github.jmgarridopaz.bluezone.hexagon;

import java.time.LocalDateTime;
import java.util.Objects;

public class Rate {
	
	private final RateName			name;
	private final Money				costPerHour;
	private final IntegerInterval	minutesAllowed;
	private final TimeTable			timetable;


	private Rate ( RateName name, Money costPerHour, IntegerInterval minutesAllowed, TimeTable timetable ) {
		this.name = name;
		this.costPerHour = costPerHour;
		this.minutesAllowed = minutesAllowed;
		this.timetable = timetable;
	}

	public static Rate fromData ( RateData rateData ) {
		return new Rate
						(
						RateName.parse(rateData.getName()),
						null, //Money.fromData(rateData.getCostPerHour())
						IntegerInterval.of ( rateData.getMinMinutesAllowed(), rateData.getMaxMinutesAllowed() ), 
						null //TimeTable.fromData(rateData.getTimetable())
						);
	}

	public RateName name() {
		return this.name;
	}

	public Money costBetweenDateTimes ( LocalDateTime from, LocalDateTime until ) {
		DateTimeInterval interval = DateTimeInterval.of(from, until);
		int minutes = this.timetable.minutes(interval);
		if ( ! this.minutesAllowed.contains ( minutes ) ) {
			throw new RuntimeException("Number of minutes ("+minutes+") not allowed. Valid range: "+this.minutesAllowed);
		}
		return ( this.costPerHour.multiply(minutes).div(60.0) );
	}


	@Override
	public int hashCode() {
		return Objects.hashCode((this.name()));
	}


	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Rate)) {
			return false;
		}
		Rate other = (Rate) obj;
		return Objects.equals(this.name(), other.name());
	}

	@Override
	public String toString() {
		return String.format("Rate [name=%s, costPerHour=%s, minutesAllowed=%s, timetable=%s]", name, costPerHour,
				minutesAllowed, timetable);
	}




}
