package boundary.action.actions;

import java.util.Collections;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.LoginSession;
import main.Context;
import model.Permission;

public class ExitAction implements Action {
	
	private final Context context;
	private final LoginSession session;
	
	public ExitAction(Context context, LoginSession session) {
		this.context = context;
		this.session = session;
	}
	
	@Override
	public String getDescription() { return "Exit"; }

	@Override
	public void performAction() { 
		session.logout();
		context.print("Thank you for using CAMs! :D");
	}

	@Override
	public ViewHandler getNextView() {
		return null;
	}

	@Override
	public List<Permission> getRequiredPermissions() { return Collections.emptyList(); }

}
