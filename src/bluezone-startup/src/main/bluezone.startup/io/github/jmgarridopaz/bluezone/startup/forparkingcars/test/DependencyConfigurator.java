package io.github.jmgarridopaz.bluezone.startup.forparkingcars.test;

import java.util.Set;
import io.github.jmgarridopaz.bluezone.adapter.forobtainingrates.stub.ForObtainingRatesStubAdapter;
import io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.TestFixture;
import io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.SystemUnderTest;
import io.github.jmgarridopaz.bluezone.adapter.forpaying.mock.ForPayingMockAdapter;
import io.github.jmgarridopaz.bluezone.adapter.forstoringpermits.fake.ForStoringPermitsFakeAdapter;
import io.github.jmgarridopaz.bluezone.hexagon.ForParkingCars;
import io.github.jmgarridopaz.bluezone.hexagon.Ticket;
import io.github.jmgarridopaz.bluezone.hexagon.RateData;


public class DependencyConfigurator implements TestFixture, SystemUnderTest {

	public DependencyConfigurator() {
	}

	@Override
	public ForParkingCars buildForParkingCarsFrom ( ForObtainingRates forObtainingRates, ForStoringPermits forStoringPermits, ForPaying forPaying) {
		return new CarParker(forObtainingRates, forStoringPermits, forPaying);
	}

	@Override
	public ForObtainingRates initRateRepositoryWith(Set<RateData> rates) {
		return new ForObtainingRatesStubAdapter(rates);
	}

	@Override
	public ForStoringPermits initPermitRepositoryWith(Set<Ticket> permits) {
		return new ForStoringPermitsFakeAdapter(permits);
	}

	@Override
	public ForPaying initPaymentRecipient() {
		return new ForPayingMockAdapter();
	}
	
}
