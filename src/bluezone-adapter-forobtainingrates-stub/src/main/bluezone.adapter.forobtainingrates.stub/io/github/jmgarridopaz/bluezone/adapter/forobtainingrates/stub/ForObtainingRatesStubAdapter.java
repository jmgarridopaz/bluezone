package io.github.jmgarridopaz.bluezone.adapter.forobtainingrates.stub;

import java.util.HashSet;
import java.util.Set;

import io.github.jmgarridopaz.bluezone.hexagon.RateData;

/**
 * 
 * Driven adapter that implements "forobtainingrates" port with a stub test double.
 * 
 */
public class ForObtainingRatesStubAdapter implements ForObtainingRates {
	
	private Set<RateData> rates;
	
	public ForObtainingRatesStubAdapter() {
		this ( new HashSet<RateData>() );
	}

	public ForObtainingRatesStubAdapter(Set<RateData> rates) {
		this.rates = rates;
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

}
