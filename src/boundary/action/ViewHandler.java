package boundary.action;

import java.util.List;

import boundary.OptionDisplayer;
import boundary.login.UserSession;
import main.Context;
import model.Permission;

public abstract class ViewHandler implements View{
	
	protected final Context context;
	protected final UserSession session;
	private View nextView;
	
	public ViewHandler(Context context, UserSession session) {
		this.context = context;
		this.session = session;
		session.getViewStack().addView(this);
	}
	
	public void displayView() throws Exception {

		ActionAuthorizer authorizer = session.getAuthorizer();
		authorizer.setPermissions(getPermissions());
		OptionDisplayer displayer = new OptionDisplayer(context, getPrompt());
		List<Action> actions = generateActions();
		
		for (Action a: actions)
			if (authorizer.isAuthorized(a))
				displayer.displayOption(a); 
		
		Action chosen = displayer.getResponse();
		chosen.performAction();
		this.nextView = chosen.getNextView();
	}
	
	protected void setNextView(ViewHandler handler) {
		this.nextView = handler;
	}
	
	protected abstract String getPrompt();
	
	protected abstract List<Action> generateActions() throws Exception;
	
	protected abstract List<Permission> getPermissions();

	public View getNextView() {
		return this.nextView;
	}
}
