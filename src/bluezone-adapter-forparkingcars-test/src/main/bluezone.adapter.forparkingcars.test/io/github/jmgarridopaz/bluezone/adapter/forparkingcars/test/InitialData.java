package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test;

import java.util.Set;

import io.github.jmgarridopaz.bluezone.hexagon.RateData;

public class InitialData {
	
	private Set<RateData> rates;

	public InitialData(Set<RateData> rates) {
		this.rates = rates;
	}

	public Set<RateData> rates() {
		return this.rates;
	}

}
