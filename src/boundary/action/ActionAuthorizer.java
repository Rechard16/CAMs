package boundary.action;

import java.util.List;

import boundary.login.LoginSession;
import model.Permission;

public class ActionAuthorizer {
	private List<Permission> permissions;
	private final LoginSession session;
	
	public ActionAuthorizer(LoginSession session) {
		this.session = session;
	}
	
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
	public boolean isAuthorized(Action action) {
		if (!session.isLoggedIn()) return false;
		return permissions.containsAll(action.getRequiredPermissions());
	}
}
