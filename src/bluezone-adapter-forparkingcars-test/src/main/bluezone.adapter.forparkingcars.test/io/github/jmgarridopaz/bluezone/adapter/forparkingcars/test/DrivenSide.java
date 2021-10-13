package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test;

import java.util.ServiceLoader;
import java.util.Set;

import io.github.jmgarridopaz.bluezone.hexagon.ForObtainingRates;
import io.github.jmgarridopaz.bluezone.hexagon.ForPaying;
import io.github.jmgarridopaz.bluezone.hexagon.ForStoringPermits;
import io.github.jmgarridopaz.bluezone.hexagon.PermitTicket;
import io.github.jmgarridopaz.bluezone.hexagon.RateData;


public interface DrivenSide {

	public static DrivenSide getInstance() {
		return ServiceLoader.load(DrivenSide.class).stream().findFirst().orElseThrow(() -> new RuntimeException("No DrivenSide provider found")).get();		
	}
	
	public ForObtainingRates initRateRepositoryWith ( Set<RateData> rates );

	public ForStoringPermits initPermitRepositoryWith ( Set<PermitTicket> permits );

	public ForPaying initPaymentRecipient();

}
