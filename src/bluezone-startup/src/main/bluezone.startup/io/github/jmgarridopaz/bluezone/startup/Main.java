package io.github.jmgarridopaz.bluezone.startup;

import io.github.jmgarridopaz.bluezone.adapter.forobtainingrates.stub.StubRateProviderAdapter;
import io.github.jmgarridopaz.bluezone.adapter.forparkingcars.webui.ForParkingCarsGetter;
import io.github.jmgarridopaz.bluezone.adapter.forparkingcars.webui.ForParkingCarsWebUIAdapter;
import io.github.jmgarridopaz.bluezone.adapter.forpaying.spy.SpyEWalletServiceAdapter;
import io.github.jmgarridopaz.bluezone.adapter.forstoringtickets.fake.FakeTicketStoreAdapter;
import io.github.jmgarridopaz.bluezone.hexagon.*;

import java.math.BigDecimal;

/**
 * Entry point to the application.
 * It selects and plugs-in an adapter on every port.
 * It runs the drivers.
 */
public class Main {

    public static ForParkingCarsGetter provider() {
        // Driven Side
        ForObtainingRates rateProvider = new StubRateProviderAdapter();
        Rate blueRate = new Rate("BLUE_RATE",new BigDecimal("0.80"));
        Rate orangeRate = new Rate("ORANGE_RATE",new BigDecimal("0.95"));
        Rate greenRate = new Rate("GREEN_RATE",new BigDecimal("1.20"));
        rateProvider.addRate(blueRate);
        rateProvider.addRate(orangeRate);
        rateProvider.addRate(greenRate);
        ForStoringTickets ticketStore = new FakeTicketStoreAdapter();
        ForPaying eWalletService = new SpyEWalletServiceAdapter();
        // App
        BlueZoneApp blueZoneApp = BlueZoneApp.instance(rateProvider, ticketStore, eWalletService);
        return new ForParkingCarsProvider(blueZoneApp);
    }

    public static void main ( String[] args ) {
        ForParkingCarsWebUIAdapter.main(args);
    }

}

//        // Driver Side
//        ForParkingCarsTestDriver forParkingCarsTestDriver = new ForParkingCarsTestDriver(blueZoneApp.carParker(), blueZoneApp.appConfigurator());
//        ForCheckingCarsTestDriver forCheckingCarsTestDriver = new ForCheckingCarsTestDriver(blueZoneApp.carChecker(), blueZoneApp.appConfigurator());
//        // Run drivers
//        if ( "for-parking-cars".equals(args[0]) ) {
//            forParkingCarsTestDriver.run();
//        } else if ( "for-checking-cars".equals(args[0]) ) {
//            forCheckingCarsTestDriver.run();
//        } else if ( "for-parking-cars_webui".equals(args[0]) ) {
//            new SpringApplicationBuilder(Main.class).child(ForParkingCarsGetter.class).run(args);
//        } else {
//            throw new IllegalArgumentException ( "Argument '" + args[0] + "' not valid" );
//        }
///**
// * Aplicación Spring Boot punto de entrada a la app
// *
// * Arranca el contexto global con todos los beans
// * Ejecuta la aplicación del adapter primario director de la app
// *
// * Escanea el paquete "dynateam.context", que contiene archivos config
// * que definen y registran todos los beans con sus dependencias
// */
//@SpringBootApplication
//public class InitApp {
//
//
//    /**
//     * MAIN
//     * 		Crea y arranca una app con el ctx global
//     * 		Le añade como hija la app del adapter primario director
//     * 		Ejecuta la app hija del adapter primario (hereda el ctx global)
//     */
//    public static void main ( String[] args ) {
//        new SpringApplicationBuilder(SbJpaDbAdapter.class).profiles("inmemory").child(InitApp.class).child(SbCliAdapter.class).run(args);
//    }
//}
