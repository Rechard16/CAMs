package boundary.login;

import main.Context;
import model.User;

public class LoginSession {
	private final String userId;
	private final Context context;
	private boolean loggedIn = false;
	private User user;
	
	public LoginSession(String userId, Context context) {
		this.userId = userId;
		this.context = context;
	}
	
	public void attemptLogin(String password) {
		try {
			user = context.getAuthenticationManager().verify(userId, password);
			loggedIn = true;
		} catch (Exception e) {
			loggedIn = false;
		}
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	
	public boolean logout() {
		if (!this.loggedIn) {
			context.print("You are already logged out of CAMs");
			return false;
		}
		this.loggedIn = false;
		context.print("Successfully logged out of CAMs.");
		return true;
	}
}
