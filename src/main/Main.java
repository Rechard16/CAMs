package main;

import java.io.IOException;

import boundary.SessionManager;
import boundary.login.LoginPortal;
import boundary.login.LoginSession;

public class Main {

	public static void main(String args[]) throws ClassNotFoundException, IOException {
		// Uncomment this to reset
		// If uncommented, all user data will NOT be saved
		// new ImportFile().importFile();
		
		Context context = Context.createDefaultContext();
		
		while(launch(context));
		context.print("Ending program. Thank you for using CAMs!");
	}
		
	private static boolean launch(Context context) {
		LoginPortal loginPortal = new LoginPortal(context);
		LoginSession session = loginPortal.openPortal();
		if (session == null) return false;
		
		SessionManager sessionManager = new SessionManager(context, session);
		sessionManager.startSession();
		return true;
	}
}