package control.manager;

import boundary.action.View;
import boundary.action.views.EntryView;
import control.login.LoginSession;
import control.login.UserSession;
import main.Context;

/**
 * SessionManager is a class that is used to manage the user's session.
 */
public class SessionManager {

	private final Context context;
	private final LoginSession loginSession;

	/*
	 * Creates a new SessionManager.
	 * 
	 * @param context The context.
	 * 
	 * @param session The login session.
	 */

	public SessionManager(Context context, LoginSession session) {
		this.context = context;
		this.loginSession = session;
	}

	/*
	 * Starts the user's session.
	 */

	public void startSession() {
		context.print("Successfully logged in as %s.\n", loginSession.getUserId());
		context.print("Welcome to CAMS!");

		try {
			runSession(new EntryView(context, new UserSession(loginSession)));
		} catch (Exception e) {
			e.printStackTrace();
			context.print("Application encountered an error! Exiting!");
		}
	}

	/*
	 * Runs the user's session.
	 * 
	 * @param currentView The current view.
	 * 
	 * @throws Exception
	 */

	private void runSession(View currentView) throws Exception {
		while (loginSession.isLoggedIn() && currentView != null) {
			currentView.displayView();
			currentView = currentView.getNextView();
		}
	}
}
