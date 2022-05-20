package io.github.jmgarridopaz.bluezone.driver.forparkingcars.test.stepdefs;

/**
 * Class for sharing state between different steps files in one scenario.
 * 
 * It is instantiated and injected into the stepdefs by PicoContainer (DI framework).
 * 
 * Put this class in stepdefs package to be recreated for every scenario.
 * 
 * So that there won't be state leakage between scenarios.
 */
public class ScenarioContext {

	public ScenarioContext() {
	}

}
