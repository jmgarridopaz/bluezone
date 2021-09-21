package io.github.jmgarridopaz.bluezone.hexagon;


public interface ForStoringPermits {

	public void save ( PermitTicket aPermitTicket );

	public PermitTicket findByCode(String permitTicketCode);

}
