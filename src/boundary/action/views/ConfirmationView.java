package boundary.action.views;

import boundary.action.Action;
import boundary.action.View;
import boundary.login.UserSession;
import boundary.reader.BooleanReader;
import main.Context;
/*
 * ConfirmationView is a class that is used to confirm actions.
 */

public class ConfirmationView implements View {
	private final Action action;
	private final Context context;
	private final UserSession session;
	private View nextView;
	/*
	 * Constructor for ConfirmationView.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param action The action to be used.
	 */

	public ConfirmationView(Context context, UserSession session, Action action) {
		this.context = context;
		this.session = session;
		this.action = action;
	}

	@Override
	/*
	 * Get the prompt.
	 * 
	 * @return "Are you sure you want to perform this action?".
	 */
	public void displayView() throws Exception {
		context.print("Are you sure you want to perform this action?");
		boolean result = new BooleanReader(context).readBool();

		if (result) {
			action.performAction();
			nextView = action.getNextView();
		} else {
			nextView = session.getViewStack().top();
		}
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public View getNextView() throws Exception {
		return nextView;
	}
}
