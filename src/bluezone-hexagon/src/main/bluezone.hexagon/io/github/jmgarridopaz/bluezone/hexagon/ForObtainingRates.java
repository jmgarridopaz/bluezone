package io.github.jmgarridopaz.bluezone.hexagon;

import java.util.Set;

/**
 * DRIVEN PORT
 */
public interface ForObtainingRates {

    public Set<Rate> findAll();

    public Rate findByName (String rateName );

    public void addRate ( Rate rate );

    public boolean exists ( String rateName );

}
