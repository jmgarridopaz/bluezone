package io.github.jmgarridopaz.bluezone.adapter.forobtainingrates.stub;

import io.github.jmgarridopaz.bluezone.hexagon.ForObtainingRates;
import io.github.jmgarridopaz.bluezone.hexagon.Rate;
import io.github.jmgarridopaz.lib.portsadapters.Adapter;

import java.util.HashSet;
import java.util.Set;

/**
 * Driven adapter that implements "forobtainingrates" port with a stub test double.
 */
@Adapter(name="test-double")
public class StubRateProviderAdapter implements ForObtainingRates {

	private Set<Rate> rates;

	public StubRateProviderAdapter() {
		this.rates = new HashSet<Rate>();
	}

	@Override
	public Set<Rate> findAll() {
		return this.rates;
	}

	@Override
	public Rate findByName ( String rateName ) {
		int occurrences = 0;
		Rate rateFound = null;
		for ( Rate rate : this.rates ) {
			if ( rate.getName().equals(rateName) ) {
				rateFound = rate;
				occurrences++;
			}
		}
		if ( occurrences==0 ) {
			return null;
		}
		if ( occurrences>1 ) {
			throw new RuntimeException("Multiple rates found with name = "+rateName);
		}
		return rateFound;
	}

	@Override
	public void addRate(Rate rate) {
		if ( exists(rate.getName()) ) {
			throw new RuntimeException("Cannot add rate to repository. Rate name '"+rate.getName()+"' already exists.");
		}
		this.rates.add(rate);
	}

	@Override
	public boolean exists ( String rateName ) {
		return ( findByName(rateName) != null );
	}

}
