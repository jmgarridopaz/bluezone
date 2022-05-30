package io.github.jmgarridopaz.bluezone.hexagon;

/**
 * Application
 * Offers driver ports as API.
 * Has a configurable dependency on driven ports.
 */
public class BlueZoneApp {

    // Driven ports
    private final ForObtainingRates rateProvider;
    private final ForStoringTickets ticketStore;
    private final ForPaying eWalletService;
    // Driver ports
    private ForParkingCars carParker;
    private ForCheckingCars carChecker;
    private ForConfiguringApp appConfigurator;

    public BlueZoneApp( ForObtainingRates rateProvider, ForStoringTickets ticketStore, ForPaying eWalletService ) {
        this.rateProvider = rateProvider;
        this.ticketStore = ticketStore;
        this.eWalletService = eWalletService;
    }

    public ForParkingCars carParker() {
        if ( this.carParker == null ) {
            this.carParker = new CarParker(this.rateProvider, this.ticketStore, this.eWalletService);
        }
        return this.carParker;
    }

    public ForCheckingCars carChecker() {
        if ( this.carChecker == null ) {
            this.carChecker = new CarChecker(this.ticketStore);
        }
        return this.carChecker;
    }

    public ForConfiguringApp appConfigurator() {
        if ( this.appConfigurator == null ) {
            this.appConfigurator = new AppConfigurator(this.rateProvider,this.ticketStore,this.eWalletService);
        }
        return this.appConfigurator;
    }

}
