package boundary.action;

import java.util.List;

import boundary.login.UserSession;
import main.Context;
import model.Permission;

public abstract class Action {
	protected final Context context;
	protected final UserSession session;
	
	public Action(Context context, UserSession session) {
		this.context = context;
		this.session = session;
	}
	
	public abstract String getDescription();
	public abstract void performAction() throws Exception;
	public abstract List<Permission> getRequiredPermissions();

	public ViewHandler getNextView() {
		return session.getViewStack().top();
	}
}
