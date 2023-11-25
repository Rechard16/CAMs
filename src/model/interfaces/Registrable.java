package model.interfaces;

import exception.UnauthorisedActionException;
import model.Camp;
import model.Role;

/**
 * The Registrable interface is used to represent an object that can be
 * registered to a camp.
 * It is used in the Camp class.
 */
public interface Registrable {
	public boolean isRegistered(Camp camp);

	public void deregister(Camp camp) throws UnauthorisedActionException;

	public Role getRole(Camp camp);

	public int getID();
}
