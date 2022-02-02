package io.github.jmgarridopaz.bluezone.startup.forcheckingcars.test;

import io.github.jmgarridopaz.bluezone.adapter.forcheckingcars.test.ForCheckingCarsTestDriver;

/**
 * Entry points to the application.
 * It runs the "forcheckingcars" test driver.
 *
 * Delegates to a dependency configurator
 * that applies configurable dependency pattern
 * at both driven and driver sides.
 */
public class Startup {

    public static void main ( String[] args ) {
        ForCheckingCarsTestDriver.main ( args );
    }

}
