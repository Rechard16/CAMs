package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.View;
import boundary.action.views.ConfirmationView;
import control.login.UserSession;
import entity.model.Permission;
import main.Context;

public class ConfirmationAction extends Action {
	private final Action action;
	/*
	 * Constructor for ConfirmationAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param action The action to be used.
	 */

	public ConfirmationAction(Context context, UserSession session, Action action) {
		super(context, session);
		this.action = action;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return The description.
	 */
	public String getDescription() {
		return action.getDescription();
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		context.print("WARNING:");
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public List<Permission> getRequiredPermissions() {
		return action.getRequiredPermissions();
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public View getNextView() {
		return new ConfirmationView(context, session, action);
	}
}
