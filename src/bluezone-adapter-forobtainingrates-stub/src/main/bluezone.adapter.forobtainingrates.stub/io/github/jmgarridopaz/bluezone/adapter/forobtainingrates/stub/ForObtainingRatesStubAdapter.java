package io.github.jmgarridopaz.bluezone.adapter.forobtainingrates.stub;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import io.github.jmgarridopaz.bluezone.hexagon.ForObtainingRates;
import io.github.jmgarridopaz.bluezone.hexagon.RateData;

/**
 * 
 * Driven adapter that implements "forobtainingrates" port with a stub test double.
 * 
 */
public class ForObtainingRatesStubAdapter implements ForObtainingRates {
	
	private Set<RateData> rates;
	
	public ForObtainingRatesStubAdapter() {
		this.rates = new HashSet<RateData>();
	}

	@Override
	public Set<RateData> getAll() {
		return this.rates;
	}

	@Override
	public RateData findByName (String rateName ) {
		int ocurrences = 0;
		RateData rateFound = null;
		for ( RateData rate : this.rates ) {
			if ( rate.getName().equals(rateName) ) {
				rateFound = rate;
				ocurrences++;
			}
		}
		if ( ocurrences==0 ) {
			throw new RuntimeException("No rates found with name = "+rateName);
		}
		if ( ocurrences>1 ) {
			throw new RuntimeException("Multiple rates found with name = "+rateName);
		}
		return rateFound;
	}

	@Override
	public void addAll(Set<RateData> rates) {
		this.rates.addAll(rates);
	}

}
