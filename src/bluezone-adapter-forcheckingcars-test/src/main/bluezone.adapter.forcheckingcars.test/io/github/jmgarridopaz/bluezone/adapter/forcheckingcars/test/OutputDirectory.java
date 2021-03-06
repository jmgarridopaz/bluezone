package io.github.jmgarridopaz.bluezone.adapter.forcheckingcars.test;

import java.io.InputStream;
import java.util.Properties;


public final class OutputDirectory {

	// defined in the pom file
	private static final String MAVEN_POM_PROPERTIES_FILE = "maven-pom.properties";
	private static final String OUTPUT_DIRECTORY_KEY = "reports.output.directory";

	private OutputDirectory() {};
	
	
	public static String get() {
		
		String outputDirectory = null;
		try (InputStream input = OutputDirectory.class.getClassLoader().getResourceAsStream(MAVEN_POM_PROPERTIES_FILE)) {
			Properties properties = new Properties();
			properties.load(input);
			outputDirectory = properties.getProperty(OUTPUT_DIRECTORY_KEY);
		} catch (Exception e) {
			throw new RuntimeException ( "Error reading '" + OUTPUT_DIRECTORY_KEY + "' key from '" + MAVEN_POM_PROPERTIES_FILE + "' file", e);
		}
		if ( outputDirectory == null ) {
			throw new RuntimeException ( "Couldn't find '" + OUTPUT_DIRECTORY_KEY + "' key in '" + MAVEN_POM_PROPERTIES_FILE + "' file");			
		}
		return outputDirectory;
	}
	
	

}
