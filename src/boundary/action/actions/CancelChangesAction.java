package boundary.action.actions;

import java.util.Collections;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import main.Context;
import model.Permission;
/*
 * CancelChangesAction is a class that is used to cancel changes.
 */

public class CancelChangesAction extends Action {
	/*
	 * Constructor for CancelChangesAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 */

	public CancelChangesAction(Context context, UserSession session) {
		super(context, session);
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Cancel current changes".
	 */
	public String getDescription() {
		return "Cancel current changes";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		context.print("Changes were not applied to your camp");
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
