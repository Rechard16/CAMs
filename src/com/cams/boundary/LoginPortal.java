package boundary;

import java.util.Scanner;

import main.Context;

public class LoginPortal {
	
	private final Context context;
	
	public LoginPortal(Context context) {
		this.context = context;
	}
	
	public LoginSession openPortal() {
		LoginSession session = null;
		while (session == null)
			session = attemptLogin();
		
		return session;
	}
	
	public LoginSession attemptLogin() {
		Scanner scanner = context.getScanner();
		context.print("Please enter your username");
		String username = scanner.nextLine();
		
		LoginSession session = new LoginSession(username, context);

		context.print("Please enter your password");
		String password = scanner.nextLine();
		session.attemptLogin(password);
		
		if (!session.isLoggedIn()) return session;
		
		context.print("Incorrect username or password!");
		return null;
		
	}
}
