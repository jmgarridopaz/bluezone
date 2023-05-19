package io.github.jmgarridopaz.bluezone.startup;

import io.github.jmgarridopaz.bluezone.hexagon.factory.BlueZoneApp;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forobtainingrates.ForObtainingRates;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forpaying.ForPaying;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forstoringtickets.ForStoringTickets;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driving.forcheckingcars.ForCheckingCars;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driving.forparkingcars.ForParkingCars;
import io.github.jmgarridopaz.lib.javalangutils.StringUtils;
import io.github.jmgarridopaz.lib.portsadapters.Driver;

/**
 * Entry point to the application.
 * It selects and plugs-in an adapter on every port.
 * It runs the drivers.
 */
public class BlueZoneRunner {

    public static void main ( String[] args ) {
        // Check args
        if ( args==null || args.length!=1 || StringUtils.isBlank(args[0]) ) {
            System.out.println("Wrong arguments. Usage: "+BlueZoneRunner.class.getSimpleName()+" path_to_file_with_ports_adapters");
            return;
        }
        // Dependency configurator with adapters to select
        AdapterSelector adapterSelector = AdapterSelector.fromFile(args[0]);
        DependencyConfigurator dependencyConfigurator = new DependencyConfigurator(adapterSelector);

        // driven side
        ForObtainingRates rateProvider = dependencyConfigurator.lookupDrivenPort(ForObtainingRates.class);
        ForStoringTickets ticketStore = dependencyConfigurator.lookupDrivenPort(ForStoringTickets.class);
        ForPaying paymentService = dependencyConfigurator.lookupDrivenPort(ForPaying.class);

        // application
        BlueZoneApp eParkingMeter = dependencyConfigurator.buildApplication(rateProvider, ticketStore, paymentService);

        // init application
        BlueZoneInitializer.init ( eParkingMeter );

        // driver side
        Driver forCheckingCarsDriver = dependencyConfigurator.lookupDriver ( ForCheckingCars.class, eParkingMeter );
        forCheckingCarsDriver.run();
        Driver forParkingCarsDriver = dependencyConfigurator.lookupDriver ( ForParkingCars.class, eParkingMeter );
        forParkingCarsDriver.run();
    }

}
