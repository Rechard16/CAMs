package boundary;

import boundary.action.ViewHandler;
import boundary.action.views.EntryView;
import boundary.login.LoginSession;
import main.Context;

public class SessionManager {
	
	private final Context context;
	private final LoginSession loginSession;
	
	public SessionManager(Context context, LoginSession session) {
		this.context = context;
		this.loginSession = session;
	}

	public void startSession() {
		context.print("Successfully logged in as %s.\n", loginSession.getUserId());
		context.print("Welcome to CAMS!");
		
		try {
			runSession(new EntryView(context, loginSession));
		} catch (Exception e) {
			e.printStackTrace();
			context.print("Application encountered an error! Exiting!");
		}

		endSession();
	}
	
	private void runSession(ViewHandler currentView) {
		while(loginSession.isLoggedIn() && currentView != null) {
			currentView.displayView();
			currentView = currentView.getNextView();
		}
	}
	
	private void endSession() {
		loginSession.logout();
		context.print("Thank you for using CAMs!");
	}
}
