package boundary.action;

import java.util.List;

import control.login.LoginSession;
import entity.model.Permission;

public class ActionAuthorizer {
	private List<Permission> permissions;
	private final LoginSession session;
	/*
	 * Constructor for ActionAuthorizer.
	 * 
	 * @param session The session to be used.
	 */

	public ActionAuthorizer(LoginSession session) {
		this.session = session;
	}
	/*
	 * Sets the permissions.
	 * 
	 * @param permissions The permissions to be set.
	 */

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	/*
	 * Checks if the action is authorized.
	 * 
	 * @param action The action to be checked.
	 * 
	 * @return True if the action is authorized, false otherwise.
	 */

	public boolean isAuthorized(Action action) {
		if (!session.isLoggedIn())
			return false;
		return permissions.containsAll(action.getRequiredPermissions());
	}
}
