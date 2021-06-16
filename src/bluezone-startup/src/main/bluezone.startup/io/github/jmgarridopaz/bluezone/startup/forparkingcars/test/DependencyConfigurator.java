package io.github.jmgarridopaz.bluezone.startup.forparkingcars.test;

import java.util.ServiceLoader;
import java.util.ServiceLoader.Provider;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import io.github.jmgarridopaz.bluezone.adapter.forobtainingrates.stub.ForObtainingRatesStubAdapter;
import io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.ForParkingCarsTestAdapter;
import io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.InitialData;
import io.github.jmgarridopaz.bluezone.hexagon.ForObtainingRates;
import io.github.jmgarridopaz.bluezone.hexagon.ForParkingCars;
import io.github.jmgarridopaz.bluezone.hexagon.RateData;
import io.github.jmgarridopaz.bluezone.startup.HardCodedHexagon;
import io.github.jmgarridopaz.bluezone.startup.HexagonProvider;


public class DependencyConfigurator {

	private final boolean hardcodedHexagon;

	private DependencyConfigurator ( boolean hardcodedHexagon ) {
		this.hardcodedHexagon = hardcodedHexagon;
	}

	static DependencyConfigurator withHardcodedHexagon() {
		return new DependencyConfigurator(true);
	}

	static DependencyConfigurator withRealHexagon() {
		return new DependencyConfigurator(false);
	}

	
	ForParkingCarsTestAdapter instantiateForParkingCarsTestAdapter() {
		Function<InitialData,ForParkingCars> forParkingCarsSetup = ( (initialData) -> getForParkingCarsInstance(initialData) );
		return new ForParkingCarsTestAdapter ( forParkingCarsSetup );
	}

	
	private ForParkingCars getForParkingCarsInstance ( InitialData initialData ) {
		ForObtainingRates forObtainingRates = instantiateForObtainingRates(initialData.rates());
		return instantiateForParkingCars(forObtainingRates);
	}


	private ForObtainingRates instantiateForObtainingRates ( Set<RateData> rates ) {
		if ( this.hardcodedHexagon ) {
			return null;
		}
		return new ForObtainingRatesStubAdapter ( rates );
	}


	private ForParkingCars instantiateForParkingCars ( ForObtainingRates forObtainingRates ) {
		return	ServiceLoader.
				load(HexagonProvider.class).
				stream().
				filter ( p -> isSelected(p) ).
				collect ( Collectors.toList() ).
				get(0).
				get().
				getForParkingCarsInstance(forObtainingRates);
	}
	
	
	private boolean isSelected ( Provider<HexagonProvider> provider ) {
		boolean isProviderAnnotatedWithHardcoded = provider.type().isAnnotationPresent(HardCodedHexagon.class);
		if ( this.hardcodedHexagon ) {
			return isProviderAnnotatedWithHardcoded;
		}
		return ( ! isProviderAnnotatedWithHardcoded );
	}

}
