package control.event;

import entity.model.User;
import main.Context;

/**
 * PasswordChangeHandler is a class that is used to handle password changes.
 */
public class PasswordChangeHandler {
	private final Context context;
	private final User user;
	/*
	 * Constructor for PasswordChangeHandler.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param user The user to be used.
	 */

	public PasswordChangeHandler(Context context, User user) {
		this.context = context;
		this.user = user;
	}
	/*
	 * Changes the user's password.
	 * 
	 * @param password The password to be used.
	 * 
	 * @return The boolean value of whether the password was changed.
	 */

	public boolean changePassword(String password) {
		if (!check(password))
			return false;
		user.setPassword(password);

		try {
			context.getUserManager().save();
		} catch (Exception e) {
			context.print("Failed to save password!");
			return false;
		}
		return true;
	}
	/*
	 * Checks if the password is valid.
	 * 
	 * @param password The password to be used.
	 * 
	 * @return The boolean value of whether the password is valid.
	 */

	private boolean check(String password) {
		if (password == null)
			return false;
		if (password.equals(user.getPassword())) {
			context.print("You cannot use the same password!");
			return false;
		}
		if (password.length() < 8) {
			context.print("Your password must be at least 8 characters long!");
			return false;
		}
		return true;
	}
}
