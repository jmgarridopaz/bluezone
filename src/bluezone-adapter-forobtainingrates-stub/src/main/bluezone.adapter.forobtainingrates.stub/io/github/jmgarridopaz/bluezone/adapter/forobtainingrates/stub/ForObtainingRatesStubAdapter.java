package io.github.jmgarridopaz.bluezone.adapter.forobtainingrates.stub;

import java.util.Set;
import io.github.jmgarridopaz.bluezone.hexagon.ForObtainingRates;
import io.github.jmgarridopaz.bluezone.hexagon.RateData;

/**
 * 
 * Driven adapter that implements "forobtainingrates" port with a stub test double.
 * 
 */
public class ForObtainingRatesStubAdapter implements ForObtainingRates {
	
	private Set<RateData> rates;
	
	public ForObtainingRatesStubAdapter ( Set<RateData> rates ) {
		this.rates = rates;
	}

	@Override
	public Set<RateData> getAll() {
		return this.rates;
	}

}
