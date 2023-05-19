package io.github.jmgarridopaz.bluezone.hexagon.factory;

import io.github.jmgarridopaz.bluezone.hexagon.AppFromDrivenSide;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forobtainingrates.ForObtainingRates;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forpaying.ForPaying;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forstoringtickets.ForStoringTickets;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driving.forcheckingcars.ForCheckingCars;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driving.forconfiguringapp.ForConfiguringApp;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driving.forparkingcars.ForParkingCars;

/**
 * API
 * Driver ports
 */
public interface BlueZoneApp {

    public static BlueZoneApp getInstance (ForObtainingRates rateProvider, ForStoringTickets ticketStore, ForPaying paymentService ) {
        return new AppFromDrivenSide(rateProvider,ticketStore,paymentService);
    }
    public ForParkingCars carParker();
    public ForCheckingCars carChecker();
    public ForConfiguringApp appConfigurator();

}
