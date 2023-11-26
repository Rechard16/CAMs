package boundary.action.actions;

import java.util.Collections;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import main.Context;
import model.Permission;
/*
 * PreviousViewAction is a class that is used to return to the previous page.
 */

public class PreviousViewAction extends Action {
	/*
	 * Constructor for PreviousViewAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 */

	public PreviousViewAction(Context context, UserSession session) {
		super(context, session);
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Return to Previous Page".
	 */
	public String getDescription() {
		return "Return to Previous Page";
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
		return session.getViewStack().pop();
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
