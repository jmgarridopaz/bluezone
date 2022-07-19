package io.github.jmgarridopaz.bluezone.hexagon;

public interface BlueZoneApp {

    public static BlueZoneApp instance ( ForObtainingRates rateProvider, ForStoringTickets ticketStore, ForPaying eWalletService ) {
        return new AppFromDrivenSide(rateProvider,ticketStore,eWalletService);
    }
    public ForParkingCars carParker();
    public ForCheckingCars carChecker();
    public ForConfiguringApp appConfigurator();

}
