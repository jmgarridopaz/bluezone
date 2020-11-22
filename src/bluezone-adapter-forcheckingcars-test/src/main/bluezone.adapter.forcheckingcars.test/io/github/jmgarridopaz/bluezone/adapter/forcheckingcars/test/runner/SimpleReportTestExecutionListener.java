package io.github.jmgarridopaz.bluezone.adapter.forcheckingcars.test.runner;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;


public class SimpleReportTestExecutionListener implements TestExecutionListener {

	private List<String> report;

	public SimpleReportTestExecutionListener() {
		this.report = new ArrayList<String>();
		this.report.add("==========================================");
		this.report.add("              TEST REPORT");
		this.report.add("==========================================");
	}

	
	@Override
	public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
		if ( testIdentifier.isTest() ) {
			this.report.add ( "TEST NAME: " + testIdentifier.getDisplayName() );
			this.report.add ( "Status: " + testExecutionResult.getStatus().toString() );
			this.report.add ( "Throwable: " + testExecutionResult.getThrowable().toString() );
			this.report.add ( "==========================================" );
		}
	}

	
	public void printReportTo ( PrintWriter printWriter ) {
		if ( printWriter==null ) {
			printWriter = new PrintWriter(System.out);
		}
		for ( String line : this.report ) {
			printWriter.println(line);
		}
	}
	
}
