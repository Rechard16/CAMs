package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import boundary.util.PasswordChangeHandler;
import main.Context;
import model.Permission;

public class ChangePasswordAction extends Action {

	public ChangePasswordAction(Context context, UserSession session) {
		super(context, session);
	}

	@Override
	public String getDescription() { return "Update Password"; }

	@Override
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
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.CHANGE_PASSWORD);
	}

}
