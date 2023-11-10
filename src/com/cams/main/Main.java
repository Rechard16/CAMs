package main;

import boundary.LoginPortal;
import boundary.LoginSession;
import boundary.SessionManager;
import manager.UserManager;

public class Main {

	public static void main(String args[]) {
		Context context = Context.createContext();
		
		while(true) launch(context);
	}
	
	private static void launch(Context context) {
		LoginPortal loginPortal = new LoginPortal(context);
		LoginSession session = loginPortal.openPortal();
		
		SessionManager sessionManager = new SessionManager(context, session);
		sessionManager.startSession();
	}
}
