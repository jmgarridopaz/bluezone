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
public class TimeTableData {

	private String[] monday;
	private String[] tuesday;
	private String[] wednesday;
	private String[] thursday;
	private String[] friday;
	private String[] saturday;
	private String[] sunday;

}
