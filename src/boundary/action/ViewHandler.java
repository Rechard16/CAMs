package boundary.action;

import java.util.List;

import boundary.OptionDisplayer;
import boundary.login.UserSession;
import main.Context;
import model.Permission;
/*
 * ViewHandler is an abstract class that is used to handle views.
 */

public abstract class ViewHandler implements View {

	protected final Context context;
	protected final UserSession session;
	private View nextView;
	/*
	 * Constructor for ViewHandler.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 */

	public ViewHandler(Context context, UserSession session) {
		this.context = context;
		this.session = session;
		session.getViewStack().addView(this);
	}
	/*
	 * Displays the view.
	 * 
	 * @throws Exception
	 */

	public void displayView() throws Exception {

		ActionAuthorizer authorizer = session.getAuthorizer();
		authorizer.setPermissions(getPermissions());
		OptionDisplayer displayer = new OptionDisplayer(context, getPrompt());
		List<Action> actions = generateActions();

		for (Action a : actions)
			if (authorizer.isAuthorized(a))
				displayer.displayOption(a);

		Action chosen = displayer.getResponse();
		chosen.performAction();
		this.nextView = chosen.getNextView();
	}
	/*
	 * Sets the next view.
	 * 
	 * @param handler The handler to be set.
	 */

	protected void setNextView(ViewHandler handler) {
		this.nextView = handler;
	}

	protected abstract String getPrompt();

	protected abstract List<Action> generateActions() throws Exception;

	protected abstract List<Permission> getPermissions();
	/*
	 * Gets the next view.
	 */

	public View getNextView() {
		return this.nextView;
	}
}
