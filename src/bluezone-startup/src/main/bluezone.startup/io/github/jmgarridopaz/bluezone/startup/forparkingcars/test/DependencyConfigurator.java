package io.github.jmgarridopaz.bluezone.startup.forparkingcars.test;

import io.github.jmgarridopaz.bluezone.adapter.forobtainingrates.stub.ForObtainingRatesStubAdapter;
import io.github.jmgarridopaz.bluezone.adapter.forpaying.mock.ForPayingMockAdapter;
import io.github.jmgarridopaz.bluezone.adapter.forstoringpermits.fake.ForStoringPermitsFakeAdapter;
import io.github.jmgarridopaz.bluezone.hexagon.ForObtainingRates;
import io.github.jmgarridopaz.bluezone.hexagon.ForPaying;
import io.github.jmgarridopaz.bluezone.hexagon.ForStoringPermits;
import io.github.jmgarridopaz.bluezone.startup.HardCodedHexagon;
import io.github.jmgarridopaz.bluezone.startup.Hexagon;
import io.github.jmgarridopaz.bluezone.startup.RealHexagon;


public class DependencyConfigurator {

	private final boolean hardcodedHexagon;

	private DependencyConfigurator ( boolean hardcodedHexagon ) {
		this.hardcodedHexagon = hardcodedHexagon;
	}

	static DependencyConfigurator forHardcodedHexagon() {
		return new DependencyConfigurator(true);
	}

	static DependencyConfigurator forRealHexagon() {
		return new DependencyConfigurator(false);
	}

	
	Hexagon instantiateHexagon() {
		if ( this.hardcodedHexagon ) {
			return new HardCodedHexagon();
		}
		ForObtainingRates forObtainingRates = new ForObtainingRatesStubAdapter();
		ForStoringPermits forStoringPermits = new ForStoringPermitsFakeAdapter();
		ForPaying forPaying = new ForPayingMockAdapter();
		return new RealHexagon(forObtainingRates,forStoringPermits,forPaying);
	}

}
