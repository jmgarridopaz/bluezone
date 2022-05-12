package io.github.jmgarridopaz.bluezone.adapter.forstoringpermits.fake;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import io.github.jmgarridopaz.bluezone.hexagon.Ticket;

/**
 * 
 * Driven adapter that implements "forstoringpermits" port with a fake test double.
 * 
 */
public class ForStoringPermitsFakeAdapter implements ForStoringPermits {

	private Map<Long,Permit> permits;
	private AtomicLong value = new AtomicLong(1);

	public ForStoringPermitsFakeAdapter() {
		this ( new HashSet<Permit>() );
	}

	public ForStoringPermitsFakeAdapter ( Set<Permit> permits ) {
		this.permits = new HashMap<Long, Permit>();
		if ( (permits!=null) && (!permits.isEmpty()) ) {
			long maxId = 0;
			permits.stream().forEach((p)->
			{
				if ( p.getId() > maxId ) {
					maxId = p.getId();
				}
				save(p);
			});
			
		}
	}

	@Override
	public String nextId() {
		return Long.toString(value.getAndIncrement());
	}

	@Override
	public void save(Ticket aPermitTicket) {
		if ( exists(aPermitTicket.getCode()) ) {
			throw new RuntimeException("Cannot store permit ticket. Code '"+aPermitTicket.getCode()+"' already exists.");
		}
		this.permits.put(aPermitTicket.getCode(),aPermitTicket);
	}

	@Override
	public Ticket findByCode(String permitTicketCode) {
		return this.permits.get(permitTicketCode);
	}

	private boolean exists ( String code ) {
		return ( this.permits.get(code) != null );
	}
	
}
