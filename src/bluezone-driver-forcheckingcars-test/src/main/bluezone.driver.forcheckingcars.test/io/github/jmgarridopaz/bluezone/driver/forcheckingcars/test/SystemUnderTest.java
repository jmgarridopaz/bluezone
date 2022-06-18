package io.github.jmgarridopaz.bluezone.driver.forcheckingcars.test;

import io.github.jmgarridopaz.bluezone.hexagon.ForCheckingCars;
import io.github.jmgarridopaz.bluezone.hexagon.ForConfiguringApp;


public enum SystemUnderTest {

    INSTANCE;

    private ForCheckingCars carChecker;
    private ForConfiguringApp appConfigurator;

    public static SystemUnderTest instance() {
        return SystemUnderTest.INSTANCE;
    }

    public void setCarChecker(ForCheckingCars carChecker) {
        this.carChecker = carChecker;
    }

    public void setAppConfigurator(ForConfiguringApp appConfigurator ) {
        this.appConfigurator = appConfigurator;
    }

    public ForConfiguringApp appConfigurator() {
        return this.appConfigurator;
    }

    public ForCheckingCars carChecker() {
        return this.carChecker;
    }
}
