package boundary.action;

import java.util.List;

import boundary.login.LoginSession;
import model.Permission;

public class ActionAuthorizer {
	private List<Permission> permissions;
	private LoginSession session;
	
	public ActionAuthorizer(List<Permission> permissions, LoginSession session) {
		this.permissions = permissions;
		this.session = session;
	}
	
	public boolean isAuthorized(Action action) {
		if (!session.isLoggedIn()) return false;
		return permissions.containsAll(action.getRequiredPermissions());
	}
}
