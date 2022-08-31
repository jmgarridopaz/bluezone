package io.github.jmgarridopaz.bluezone.startup;

import io.github.jmgarridopaz.bluezone.hexagon.BlueZoneApp;
import io.github.jmgarridopaz.bluezone.hexagon.Rate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class BlueZoneInitializer {

    public static void init(BlueZoneApp eParkingMeter) {
        // rates
        List<Rate> initialRates = new ArrayList<Rate>();
        initialRates.add(new Rate("BLUE_RATE", new BigDecimal("0.80")));
        initialRates.add(new Rate("ORANGE_RATE", new BigDecimal("0.95")));
        initialRates.add(new Rate("GREEN_RATE", new BigDecimal("1.20")));
        eParkingMeter.appConfigurator().createRates(initialRates);
    }

}
