package model;

import exception.UnauthorisedActionException;

public interface Registrable {
	public boolean isRegistered(Camp camp);
	public void deregister(Camp camp) throws UnauthorisedActionException;
	public Role getRole(Camp camp);
	public int getID();
}
