package control.login;

import entity.model.User;
import main.Context;

/**
 * LoginSession is a class that is used to manage the user's login session.
 */

public class LoginSession {
	private final String userId;
	private final Context context;
	private boolean loggedIn = false;
	private User user;
	/*
	 * Constructor for LoginSession.
	 * 
	 * @param userId The user ID to be used.
	 * 
	 * @param context The context to be used.
	 */

	public LoginSession(String userId, Context context) {
		this.userId = userId;
		this.context = context;
	}
	/*
	 * Attempts to login.
	 * 
	 * @param password The password to be used.
	 */

	public void attemptLogin(String password) {
		try {
			user = context.getAuthenticationManager().verify(userId, password);
			loggedIn = true;
		} catch (Exception e) {
			loggedIn = false;
		}
	}
	/*
	 * Gets the user ID.
	 * 
	 * @return The user ID.
	 */

	public String getUserId() {
		return this.userId;
	}
	/*
	 * Gets the user.
	 * 
	 * @return The user.
	 */

	public User getUser() {
		return this.user;
	}
	/*
	 * Checks if the user is logged in.
	 * 
	 * @return The boolean value of whether the user is logged in.
	 */

	public boolean isLoggedIn() {
		return loggedIn;
	}
	/*
	 * Logs the user out.
	 * 
	 * @return The boolean value of whether the user was logged out.
	 */

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
