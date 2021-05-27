package io.github.jmgarridopaz.bluezone.hexagon.rate;


public class Rate {

	private final String name;

	public Rate(String name) {
		this.name = name;
	}
	
	public String name() {
		return this.name;
	}
	
	public RateData toData() {
		RateData rateData = new RateData();
		rateData.setName(this.name);
		return rateData;
	}
	
	
}
