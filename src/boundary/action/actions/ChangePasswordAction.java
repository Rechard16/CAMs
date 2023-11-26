package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import control.event.PasswordChangeHandler;
import control.login.UserSession;
import entity.model.Permission;
import main.Context;

public class ChangePasswordAction extends Action {
	/*
	 * Constructor for ChangePasswordAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 */

	public ChangePasswordAction(Context context, UserSession session) {
		super(context, session);
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Update Password".
	 */
	public String getDescription() {
		return "Update Password";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		PasswordChangeHandler handler = new PasswordChangeHandler(context, session.getUser());
		while (true) {
			context.print("Please enter a password:");
			String password = context.getScanner().nextLine();
			if (handler.changePassword(password)) {
				context.print("Password changed!");
				return;
			}
		}
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.CHANGE_PASSWORD);
	}

}
