package io.github.jmgarridopaz.bluezone.hexagon;

/**
 * API
 * Driver ports
 */
public interface BlueZoneApp {

    public static BlueZoneApp getInstance ( ForObtainingRates rateProvider, ForStoringTickets ticketStore, ForPaying paymentService ) {
        return new AppFromDrivenSide(rateProvider,ticketStore,paymentService);
    }
    public ForParkingCars carParker();
    public ForCheckingCars carChecker();
    public ForConfiguringApp appConfigurator();

}
