package main;

import java.io.IOException;

import boundary.login.LoginPortal;
import control.database.ImportFile;
import control.login.LoginSession;
import control.manager.SessionManager;

/**
 * Main class is the entry point of the program.
 * It creates the Context object and starts the program.
 */
public class Main {
	/**
	 * Main method for the Main class.
	 * 
	 * @param args The command line arguments.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public static void main(String args[]) throws ClassNotFoundException, IOException {
		// Uncomment this to reset
		// If uncommented, all user data will NOT be saved
		// new ImportFile().importFile();

		Context context = Context.createDefaultContext();

		while (launch(context))
			;
		context.print("Ending program. Thank you for using CAMs!");
	}

	/**
	 * Creates a default Context object.
	 * 
	 * @return The Context object.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	private static boolean launch(Context context) {
		LoginPortal loginPortal = new LoginPortal(context);
		LoginSession session = loginPortal.openPortal();
		if (session == null)
			return false;

		SessionManager sessionManager = new SessionManager(context, session);
		sessionManager.startSession();
		return true;
	}
}