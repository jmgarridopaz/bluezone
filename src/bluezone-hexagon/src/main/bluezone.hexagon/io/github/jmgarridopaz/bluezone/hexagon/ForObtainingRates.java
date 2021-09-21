package io.github.jmgarridopaz.bluezone.hexagon;

import java.util.Set;


public interface ForObtainingRates {

	public Set<RateData> getAll();

	public RateData findByName(String rateName);

	public void addAll(Set<RateData> rates);
	
}
