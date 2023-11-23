package boundary.util;

import main.Context;
import model.User;

public class PasswordChangeHandler {
	private final Context context;
	private final User user;
	
	public PasswordChangeHandler(Context context, User user) {
		this.context = context;
		this.user = user;
	}
	
	public boolean changePassword(String password) {
		if (!check(password)) return false;
		user.setPassword(password);
		
		//TODO
		return true;
	}
	
	private boolean check(String password) {
		if (password == null) return false;
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
