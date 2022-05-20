package io.github.jmgarridopaz.bluezone.hexagon;

import java.util.Set;

/**
 * DRIVEN PORT
 */
public interface ForObtainingRates {

    public Set<RateData> findAll();

    public RateData findByName ( String rateName );

}
