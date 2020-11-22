package io.github.jmgarridopaz.bluezone.adapter.forcheckingcars.test.runner;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;
import java.io.PrintWriter;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TagFilter;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;


public class JUnit5Runner {	
	
	public JUnit5Runner () {}

	
	public void runTaggedTestsOfPackage ( String testCasesPackage, String tagExpressionToRun ) {
		
		SimpleReportTestExecutionListener reportListener = new SimpleReportTestExecutionListener();
		SummaryGeneratingListener summaryListener = new SummaryGeneratingListener();		
		LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
											.selectors(
													selectPackage ( testCasesPackage )
										    )
										    .filters(
										    		TagFilter.includeTags ( tagExpressionToRun )
										    )
										    .build();
		PrintWriter sysOutPrintWriter = new PrintWriter(System.out);
				
		Launcher launcher = LauncherFactory.create();
		launcher.registerTestExecutionListeners ( reportListener, summaryListener );
		launcher.execute ( request );
		
		reportListener.printReportTo ( sysOutPrintWriter );
		summaryListener.getSummary().printTo ( sysOutPrintWriter );		
	}

}
