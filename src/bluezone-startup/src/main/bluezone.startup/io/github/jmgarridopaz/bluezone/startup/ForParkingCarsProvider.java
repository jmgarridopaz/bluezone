package io.github.jmgarridopaz.bluezone.startup;

import io.github.jmgarridopaz.bluezone.adapter.forobtainingrates.stub.StubRateProviderAdapter;
import io.github.jmgarridopaz.bluezone.adapter.forparkingcars.webui.ForParkingCarsGetter;
import io.github.jmgarridopaz.bluezone.adapter.forpaying.spy.SpyEWalletServiceAdapter;
import io.github.jmgarridopaz.bluezone.adapter.forstoringtickets.fake.FakeTicketStoreAdapter;
import io.github.jmgarridopaz.bluezone.hexagon.*;

public class ForParkingCarsProvider implements ForParkingCarsGetter {

    private final BlueZoneApp blueZoneApp;

    public ForParkingCarsProvider ( BlueZoneApp blueZoneApp ) {
        this.blueZoneApp = blueZoneApp;
    }

    @Override
    public ForParkingCars getCarParker() {
        return this.blueZoneApp.carParker();
    }

}
