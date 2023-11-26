package entity;

import entity.exception.UnauthorisedActionException;
import entity.model.Camp;
import entity.model.Role;

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
