package io.github.jmgarridopaz.bluezone.adapter.forstoringpermits.fake;

import java.util.HashMap;
import java.util.Map;

import io.github.jmgarridopaz.bluezone.hexagon.ForStoringPermits;
import io.github.jmgarridopaz.bluezone.hexagon.PermitTicket;

/**
 * 
 * Driven adapter that implements "forstoringpermits" port with a fake test double.
 * 
 */
public class ForStoringPermitsFakeAdapter implements ForStoringPermits {

	private Map<String,PermitTicket> permits;
	
	public ForStoringPermitsFakeAdapter() {
		this.permits = new HashMap<String, PermitTicket>();
	}

	@Override
	public void save(PermitTicket aPermitTicket) {
		if ( exists(aPermitTicket.getCode()) ) {
			throw new RuntimeException("Cannot store permit ticket. Code '"+aPermitTicket.getCode()+"' already exists.");
		}
		this.permits.put(aPermitTicket.getCode(),aPermitTicket);
	}

	@Override
	public PermitTicket findByCode(String permitTicketCode) {
		return this.permits.get(permitTicketCode);
	}

	private boolean exists ( String code ) {
		return ( this.permits.get(code) != null );
	}
	
}
