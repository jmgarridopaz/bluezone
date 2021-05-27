package io.github.jmgarridopaz.bluezone.adapter.forobtainingrates.stub;

import java.util.List;
import java.util.Set;

import io.github.jmgarridopaz.bluezone.hexagon.driven.forobtainingrates.ForObtainingRates;
import io.github.jmgarridopaz.bluezone.hexagon.driver.forparkingcars.RateData;
import io.github.jmgarridopaz.bluezone.hexagon.driver.forparkingcars.implementation.Rate;

/**
 * 
 * Driven adapter that implements "forobtainingrates" port with a stub test double.
 * 
 */
public class ForObtainingRatesStubAdapter implements ForObtainingRates {
	
	public ForObtainingRatesStubAdapter ( List<RateData> rates ) {
	}

	public static ForObtainingRates provider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Rate> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
