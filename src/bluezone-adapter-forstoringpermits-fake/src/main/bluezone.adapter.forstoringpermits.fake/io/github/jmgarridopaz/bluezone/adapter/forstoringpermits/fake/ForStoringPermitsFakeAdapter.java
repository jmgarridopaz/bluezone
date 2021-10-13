package io.github.jmgarridopaz.bluezone.adapter.forstoringpermits.fake;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
		this ( new HashSet<PermitTicket>() );
	}

	public ForStoringPermitsFakeAdapter ( Set<PermitTicket> permits ) {
		this.permits = new HashMap<String, PermitTicket>();
		if ( (permits!=null) && (!permits.isEmpty()) ) {
			permits.stream().forEach((p)->save(p));
			
		}
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
