package boundary.login;

import java.util.Scanner;

import main.Context;

public class LoginPortal {
	
	public static final int MAX_LOGIN_TRIES=3;
	
	private final Context context;
	
	public LoginPortal(Context context) {
		this.context = context;
	}
	
	public LoginSession openPortal() {
		LoginSession session = null;
		for (int i=0;i<3;i++) {
			session = attemptLogin();
			if (session != null) return session;
		}
		context.print("Too many unsuccessful login attempts >:( Shutting down...");
		return null;
	}
	
	public LoginSession attemptLogin() {
		Scanner scanner = context.getScanner();
		context.print("Please enter your username");
		String username = scanner.next();
		
		LoginSession session = new LoginSession(username, context);

		context.print("Please enter your password");
		String password = scanner.next();
		session.attemptLogin(password);
		
		if (session.isLoggedIn()) return session;
		
		context.print("Incorrect username or password!");
		return null;
		
	}
}
