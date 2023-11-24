package boundary.action.views;

import boundary.action.Action;
import boundary.action.View;
import boundary.login.UserSession;
import boundary.reader.BooleanReader;
import main.Context;

public class ConfirmationView implements View {
	private final Action action;
	private final Context context;
	private final UserSession session;
	private View nextView;

	public ConfirmationView(Context context, UserSession session, Action action) {
		this.context = context;
		this.session = session;
		this.action = action;
	}

	@Override
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
	public View getNextView() throws Exception {
		return nextView;
	}
}
