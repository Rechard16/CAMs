package boundary.action.actions;

import java.util.Collections;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import main.Context;
import model.Permission;

public class ExitAction extends Action {
	
	public ExitAction(Context context, UserSession session) {
		super(context, session);
	}
	
	@Override
	public String getDescription() { return "Exit"; }

	@Override
	public void performAction() { session.getLoginSession().logout(); }

	@Override
	public ViewHandler getNextView() {
		return null;
	}

	@Override
	public List<Permission> getRequiredPermissions() { return Collections.emptyList(); }

}
