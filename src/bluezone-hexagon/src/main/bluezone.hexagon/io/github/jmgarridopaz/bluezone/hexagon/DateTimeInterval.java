package io.github.jmgarridopaz.bluezone.hexagon;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;


public class DateTimeInterval {

	private final LocalDateTime startInclusive;
	private final LocalDateTime endExclusive;

	
	private DateTimeInterval ( LocalDateTime from, LocalDateTime until ) {
		if ( from.isAfter(until) ) {
			throw new RuntimeException("from DateTime ("+from+") cannot be after until DateTime ("+until+")");
		}
		this.startInclusive = from;
		this.endExclusive = until;
	}

	public static DateTimeInterval of (LocalDateTime fromInclusive, LocalDateTime untilExclusive ) {
		return new DateTimeInterval(fromInclusive,untilExclusive);
	}
	

	public LocalDate startingDate() {
		return this.startInclusive.toLocalDate();
	}

	public LocalDate endingDate() {
		return this.endExclusive.toLocalDate();
	}

	
	public int overlappedMinutes ( DateTimeInterval other ) {
		LocalDateTime overlappedStartInclusive = max ( this.startInclusive, other.startInclusive );
		LocalDateTime overlappedEndExclusive = min ( this.endExclusive, other.endExclusive );
		if ( overlappedStartInclusive.isAfter(overlappedEndExclusive) ) {
			return 0;
		}
		return
				Long.valueOf
				(
				Duration.between(overlappedStartInclusive,overlappedEndExclusive).toMinutes()
				)
				.intValue();
	}

	
	private LocalDateTime max (LocalDateTime aDateTime, LocalDateTime otherDateTime) {
		if ( otherDateTime.isAfter(aDateTime)) {
			return otherDateTime;
		}
		return aDateTime;
	}
	
	private LocalDateTime min (LocalDateTime aDateTime, LocalDateTime otherDateTime) {
		if ( otherDateTime.isBefore(aDateTime)) {
			return otherDateTime;
		}
		return aDateTime;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(this.startInclusive,this.endExclusive);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof DateTimeInterval)) {
			return false;
		}
		DateTimeInterval other = (DateTimeInterval) obj;
		return Objects.equals(this.startInclusive, other.startInclusive) && Objects.equals(this.endExclusive, other.endExclusive);
	}

	@Override
	public String toString() {
		return String.format("DateTimeInterval [startInclusive=%s, endExclusive=%s]", this.startInclusive, this.endExclusive);
	}

}
