package boundary.action.actions;

import java.util.Collections;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import model.Permission;

public class PreviousViewAction implements Action {
	private final UserSession session;

	public PreviousViewAction(UserSession session) {
		this.session = session;
	}
	
	@Override
	public String getDescription() { return "Return to Previous Page"; }
	
	@Override
	public void performAction() {}
	
	@Override
	public ViewHandler getNextView() {
		return session.getViewStack().pop();
	}
	
	@Override
	public List<Permission> getRequiredPermissions() { 
		return Collections.emptyList();
	}
}
