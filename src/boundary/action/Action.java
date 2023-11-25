package boundary.action;

import java.util.List;

import boundary.login.UserSession;
import main.Context;
import model.Permission;

/*
 * Action is an abstract class that is used to perform actions.
 */
public abstract class Action {
	protected final Context context;
	protected final UserSession session;
	/*
	 * Constructor for Action.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 */

	public Action(Context context, UserSession session) {
		this.context = context;
		this.session = session;
	}

	public abstract String getDescription();

	public abstract void performAction() throws Exception;

	public abstract List<Permission> getRequiredPermissions();
	/*
	 * Gets the next view.
	 */

	public View getNextView() {
		return session.getViewStack().top();
	}
}
