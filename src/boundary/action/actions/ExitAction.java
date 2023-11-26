package boundary.action.actions;

import java.util.Collections;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import control.login.UserSession;
import entity.model.Permission;
import main.Context;

public class ExitAction extends Action {
	/*
	 * Constructor for ExitAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 */

	public ExitAction(Context context, UserSession session) {
		super(context, session);
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Exit".
	 */
	public String getDescription() {
		return "Exit";
	}

	@Override
	/*
	 * Perform the action.
	 */
	public void performAction() {
		session.getLoginSession().logout();
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return null.
	 */
	public ViewHandler getNextView() {
		return null;
	}

	@Override
	/*
	 * Get the required permissions.
	 * 
	 * @return An empty list.
	 */
	public List<Permission> getRequiredPermissions() {
		return Collections.emptyList();
	}

}
