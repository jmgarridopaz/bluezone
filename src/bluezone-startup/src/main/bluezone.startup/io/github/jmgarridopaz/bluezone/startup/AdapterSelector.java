package io.github.jmgarridopaz.bluezone.startup;

import io.github.jmgarridopaz.lib.javalangutils.FileUtils;
import java.nio.file.Paths;
import java.util.Properties;


public class AdapterSelector {

    public static final String TEST_CASES = "test-cases";
    public static final String WEB_UI = "web-ui";

    private final Properties adaptersToSelect;

    private AdapterSelector(Properties adaptersToSelect) {
        this.adaptersToSelect = adaptersToSelect;
    }

    public static AdapterSelector fromFile ( String fileWithPath ) {
        Properties adaptersToSelectForPorts = FileUtils.propertiesFromFile ( Paths.get(fileWithPath) );
        return new AdapterSelector ( adaptersToSelectForPorts );
    }

    public String adapterNameForPort(Class<?> portType) {
        return adaptersToSelect.getProperty(portType.getSimpleName());
    }
}
