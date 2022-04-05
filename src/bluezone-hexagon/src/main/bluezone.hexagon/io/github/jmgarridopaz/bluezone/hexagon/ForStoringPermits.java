package io.github.jmgarridopaz.bluezone.hexagon;


public interface ForStoringPermits {

	public String nextId();

	public void save ( Permit aPermit );

	public Permit findById ( String permitId );

}
