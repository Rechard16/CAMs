package boundary.action.actions;

import java.util.Collections;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import main.Context;
import model.Permission;

public class ReturnHomeAction extends Action {

	public ReturnHomeAction(Context context, UserSession session) {
		super(context, session);
	}
	
	@Override
	public String getDescription() { return "Return to Home Page"; }
	
	@Override
	public void performAction() {}
	
	@Override
	public ViewHandler getNextView() {
		return session.getViewStack().reset();
	}
	
	@Override
	public List<Permission> getRequiredPermissions() { 
		return Collections.emptyList();
	}
}
