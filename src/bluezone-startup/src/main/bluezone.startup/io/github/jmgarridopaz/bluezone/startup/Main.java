package io.github.jmgarridopaz.bluezone.startup;


import io.github.jmgarridopaz.bluezone.adapter.forobtainingrates.stub.StubRateProviderAdapter;
import io.github.jmgarridopaz.bluezone.adapter.forstoringtickets.fake.FakeTicketStoreAdapter;
import io.github.jmgarridopaz.bluezone.driver.forparkingcars.test.ForParkingCarsTestDriver;
import io.github.jmgarridopaz.bluezone.hexagon.*;

/**
 * Entry point to the application.
 * It selects and plugs-in an adapter on every port.
 * It runs the drivers.
 */
public class Main {

    public static void main ( String[] args ) {
        // Driven Side
        ForObtainingRates rateProvider = new StubRateProviderAdapter();
        ForStoringTickets ticketStore = new FakeTicketStoreAdapter();
        ForPaying eWalletService = new SpyEWalletServiceAdapter();
        // App
        BlueZoneApp blueZoneApp = new BlueZoneApp(rateProvider, ticketStore,eWalletService);
        // Driver Side
        ForParkingCarsTestDriver forParkingCarsTestDriver = new ForParkingCarsTestDriver(blueZoneApp.carParker(), blueZoneApp.appConfigurator());
        // Run drivers
        forParkingCarsTestDriver.run();
    }

}
