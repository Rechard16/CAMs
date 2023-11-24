package boundary.action.actions;

import java.util.Collections;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import main.Context;
import model.Permission;

public class CancelChangesAction extends Action {

	public CancelChangesAction(Context context, UserSession session) {
		super(context, session);
	}

	@Override
	public String getDescription() {
		return "Cancel current changes";
	}

	@Override
	public void performAction() throws Exception {
		context.print("Changes were not applied to your camp");
	}
	
	@Override
	public ViewHandler getNextView() {
		return session.getViewStack().reset();
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return Collections.emptyList();
	}

}
