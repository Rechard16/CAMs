package boundary.login;

import java.util.Scanner;

import main.Context;

public class LoginPortal {
	
	public static final int MAX_LOGIN_TRIES=3;
	
	private final Context context;
	private final Scanner scanner;
	
	public LoginPortal(Context context) {
		this.context = context;
		this.scanner = context.getScanner();
	}
	
	public LoginSession openPortal() {
		try {
			LoginSession session = createSession();
			return session;
		} catch (UnsuccessfulLoginException e) {
			context.print(e.getMessage());
		}
		return null;
	}
	
	public LoginSession createSession() throws UnsuccessfulLoginException {
		for (int i=0;i<3;i++) {
			Scanner scanner = context.getScanner();
			context.print("Please enter your username");
			String username = scanner.nextLine();
			if (username.length() == 0) return null;
			LoginSession session = attemptLogin(username);
			if (session != null) return session;
		}
		throw new UnsuccessfulLoginException();
	}
	
	public LoginSession attemptLogin(String username) {
		
		LoginSession session = new LoginSession(username, context);

		context.print("Please enter your password");
		String password = scanner.nextLine();
		session.attemptLogin(password);
		
		if (session.isLoggedIn()) return session;
		
		context.print("Incorrect username or password!");
		return null;
	}
}
