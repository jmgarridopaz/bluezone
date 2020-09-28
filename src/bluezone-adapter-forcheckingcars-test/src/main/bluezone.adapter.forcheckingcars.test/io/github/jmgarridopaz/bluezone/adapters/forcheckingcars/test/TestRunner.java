package io.github.jmgarridopaz.bluezone.adapters.forcheckingcars.test;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;
import java.io.PrintWriter;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TagFilter;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;


public class TestRunner {

	private final boolean hardCodedHexagon;
	private TestExecutionSummary summary;

	
	public TestRunner ( boolean hardCodedHexagon ) {
		this.hardCodedHexagon = hardCodedHexagon;
	}


	public void runAllFeatures() {
		LauncherDiscoveryRequest request =	LauncherDiscoveryRequestBuilder.request()
											.selectors(selectPackage(ForCheckingCarsTestAdapter.class.getPackageName()))
											.filters(TagFilter.includeTags("security"))
											.build();
		Launcher launcher = LauncherFactory.create();
		SummaryGeneratingListener listener = new SummaryGeneratingListener();
		launcher.registerTestExecutionListeners(listener);
		launcher.execute(request);
		this.summary = listener.getSummary();
	}


	public void printExecutionSummary() {
		if ( this.summary == null ) {
			System.out.println("No execution summary.");
		}
		this.summary.printTo(new PrintWriter(System.out));
	}
	
}
