package boundary.login;

import java.util.Scanner;

import boundary.util.PasswordChangeHandler;
import exception.UnsuccessfulLoginException;
import main.Context;

/**
 * LoginPortal is a class that is used to log users in.
 */

public class LoginPortal {

	public static final int MAX_LOGIN_TRIES = 3;

	private final Context context;
	private final Scanner scanner;
	/*
	 * Constructor for LoginPortal.
	 * 
	 * @param context The context to be used.
	 */

	public LoginPortal(Context context) {
		this.context = context;
		this.scanner = context.getScanner();
	}
	/*
	 * Opens the login portal.
	 * 
	 * @return The session that was opened.
	 */

	public LoginSession openPortal() {
		try {
			LoginSession session = createSession();
			if (session != null && session.getUser().getPassword().equals("password")) {
				context.print("You are still using the default password. Please enter a new password");
				PasswordChangeHandler handler = new PasswordChangeHandler(context, session.getUser());
				while (true) {
					context.print("Please enter a password:");
					String password = context.getScanner().nextLine();
					if (handler.changePassword(password)) {
						context.print("Password changed!");
						break;
					}
				}
			}
			return session;
		} catch (UnsuccessfulLoginException e) {
			context.print(e.getMessage());
		}
		return null;
	}
	/*
	 * Creates a login session.
	 * 
	 * @return The session that was created.
	 * 
	 * @throws UnsuccessfulLoginException If the login was unsuccessful.
	 */

	public LoginSession createSession() throws UnsuccessfulLoginException {
		for (int i = 0; i < 3; i++) {
			Scanner scanner = context.getScanner();
			context.print("Please enter your username");
			String username = scanner.nextLine();
			if (username.length() == 0)
				return null;
			LoginSession session = attemptLogin(username);
			if (session != null)
				return session;
		}
		throw new UnsuccessfulLoginException();
	}
	/*
	 * Attempts to log a user in.
	 * 
	 * @param username The username of the user to be logged in.
	 * 
	 * @return The session that was created.
	 */

	public LoginSession attemptLogin(String username) {

		LoginSession session = new LoginSession(username, context);

		context.print("Please enter your password");
		String password = scanner.nextLine();
		session.attemptLogin(password);

		if (session.isLoggedIn())
			return session;

		context.print("Incorrect username or password!");
		return null;
	}
}
