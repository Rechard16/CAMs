package boundary.action.actions;

import java.util.Collections;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import control.login.UserSession;
import entity.model.Permission;
import main.Context;

public class ReturnHomeAction extends Action {
	/*
	 * Constructor for ReturnHomeAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 */

	public ReturnHomeAction(Context context, UserSession session) {
		super(context, session);
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Return to Home Page".
	 */
	public String getDescription() {
		return "Return to Home Page";
	}

	@Override
	/*
	 * Perform the action.
	 */
	public void performAction() {
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public ViewHandler getNextView() {
		return session.getViewStack().reset();
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
