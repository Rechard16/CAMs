package boundary.action;

import java.util.List;

import boundary.OptionDisplayer;
import boundary.login.UserSession;
import main.Context;
import model.Permission;

public abstract class ViewHandler {
	
	protected final Context context;
	protected final UserSession session;
	private ViewHandler nextView;
	
	public ViewHandler(Context context, UserSession session) {
		this.context = context;
		this.session = session;
		session.getViewStack().addView(this);
	}
	
	public void displayView() throws Exception {

		ActionAuthorizer authorizer = session.getAuthorizer();
		authorizer.setPermissions(getPermissions());
		context.print("-----------------------------------------------------------");
		OptionDisplayer displayer = new OptionDisplayer(context, getPrompt());
		List<Action> actions = generateActions();
		
		for (Action a: actions)
			if (authorizer.isAuthorized(a))
				displayer.displayOption(a); 
		
		Action chosen = displayer.getResponse();
		chosen.performAction();
		this.nextView = chosen.getNextView();
	}
	
	protected abstract String getPrompt();
	
	protected abstract List<Action> generateActions();
	
	protected abstract List<Permission> getPermissions();

	public ViewHandler getNextView() {
		return this.nextView;
	}
}
