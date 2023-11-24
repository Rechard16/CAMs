package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.View;
import boundary.action.views.ConfirmationView;
import boundary.login.UserSession;
import main.Context;
import model.Permission;

public class ConfirmationAction extends Action {
	private final Action action;

	public ConfirmationAction(Context context, UserSession session, Action action) {
		super(context, session);
		this.action = action;
	}

	@Override
	public String getDescription() {
		return action.getDescription();
	}

	@Override
	public void performAction() throws Exception {
		context.print("WARNING:");
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return action.getRequiredPermissions();
	}
	
	@Override
	public View getNextView() {
		return new ConfirmationView(context, session, action);
	}
}
