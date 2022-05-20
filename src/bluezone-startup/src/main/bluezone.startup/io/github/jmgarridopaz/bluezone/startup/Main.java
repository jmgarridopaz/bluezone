package io.github.jmgarridopaz.bluezone.startup;


import io.github.jmgarridopaz.bluezone.driver.forparkingcars.test.ForParkingCarsTestDriver;

/**
 * Entry points to the application.
 * It selects and plugs-in an adapter on every port.
 * It runs the drivers.
 */
public class Main {

    public static void main ( String[] args ) {
        ForParkingCarsTestDriver.main ( args );
    }

}
