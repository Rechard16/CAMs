package boundary;

import javax.naming.AuthenticationException;

import manager.UserManager;
import model.User;

public class AuthenticationManager {
	
	private final UserManager userManager;
	
	public AuthenticationManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
	// TODO
	public User verify(String userId, String password) throws AuthenticationException {
		User user = userManager.getUserByID(userId);
		if (user == null || "TODO" != password)
			throw new AuthenticationException("User failed to login");
		else return user;
	}
}