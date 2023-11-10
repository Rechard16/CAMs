package boundary.action;

import java.util.List;

import boundary.OptionDisplayer;
import boundary.login.LoginSession;
import main.Context;
import model.Permission;

public abstract class ViewHandler {
	
	protected final Context context;
	protected final LoginSession session;
	private final ActionAuthorizer authorizer;
	private ViewHandler nextView;
	
	public ViewHandler(Context context, LoginSession session) {
		this.context = context;
		this.session = session;
		this.authorizer = new ActionAuthorizer(getPermissions(), session);
	}
	
	public void displayView() {
		OptionDisplayer displayer = new OptionDisplayer(context, getPrompt());
		List<Action> actions = generateActions();
		
		for (Action a: actions)
			if (authorizer.isAuthorized(a))
				displayer.displayOption(a); 
		
		Action chosen = displayer.getResponse();
		chosen.performAction();
	}
	
	protected abstract String getPrompt();
	
	protected abstract List<Action> generateActions();
	
	protected abstract List<Permission> getPermissions();

	public ViewHandler getNextView() {
		return this.nextView;
	}
}
