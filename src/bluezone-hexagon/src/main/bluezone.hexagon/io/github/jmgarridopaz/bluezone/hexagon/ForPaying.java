package io.github.jmgarridopaz.bluezone.hexagon;

/**
 * DRIVEN PORT
 */
public interface ForPaying {

    public void pay ( PayRequest payRequest ) throws PayErrorException;

    public PayRequest lastPayRequest();

    public void setPayErrorGenerationPercentage(int percent);

}
