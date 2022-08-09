package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.webui;

import io.github.jmgarridopaz.bluezone.hexagon.ForParkingCars;
import io.github.jmgarridopaz.lib.portsadapters.Driver;


public class ForParkingCarsWebUIDriver implements Driver {

    private static ForParkingCars carParker;

    public ForParkingCarsWebUIDriver ( ForParkingCars carParker ) {
        ForParkingCarsWebUIDriver.carParker = carParker;
    }

    public static ForParkingCars carParker() {
        return ForParkingCarsWebUIDriver.carParker;
    }

    @Override
    public void run(String... args) {
        WebUISpringBootApp.main(args);
    }

}
