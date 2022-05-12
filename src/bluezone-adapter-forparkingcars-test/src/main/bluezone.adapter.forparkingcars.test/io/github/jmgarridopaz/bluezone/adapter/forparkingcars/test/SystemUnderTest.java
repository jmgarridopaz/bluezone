package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test;

import java.util.ServiceLoader;

import io.github.jmgarridopaz.bluezone.hexagon.ForParkingCars;


public interface SystemUnderTest {

	public static SystemUnderTest provider() {
		return ServiceLoader.load(SystemUnderTest.class).stream().findFirst().orElseThrow(() -> new RuntimeException("No SUT provider found")).get();
	}

	public ForParkingCars buildForParkingCarsFrom ( ForObtainingRates rateRepository, ForStoringPermits permitRepository, ForPaying paymentRecipient );

}
