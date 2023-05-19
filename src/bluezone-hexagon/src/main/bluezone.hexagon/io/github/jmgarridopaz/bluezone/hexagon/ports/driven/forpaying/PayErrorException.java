package io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forpaying;

/**
 * Exception thrown by the pay method in the "for paying" port,
 * when it has been any error and the payment didn't take place.
 */
public class PayErrorException extends RuntimeException {

    public PayErrorException ( String errorMessage ) {
        super(errorMessage);
    }

}
