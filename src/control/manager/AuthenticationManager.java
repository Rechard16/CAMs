package control.manager;

import javax.naming.AuthenticationException;

import entity.model.User;

/**
 * AuthenticationManager is a class that is used to manage authentication.
 */
public class AuthenticationManager {

	private final UserManager userManager;
	/*
	 * Constructor for AuthenticationManager.
	 * 
	 * @param userManager The user manager to be used.
	 */

	public AuthenticationManager(UserManager userManager) {
		this.userManager = userManager;
	}
	/*
	 * Verifies a user.
	 * 
	 * @param userId The user ID to be used.
	 * 
	 * @param password The password to be used.
	 * 
	 * @return The user that was verified.
	 * 
	 * @throws Exception
	 */

	public User verify(String userId, String password) throws Exception {
		User user = userManager.getUserByID(userId);
		if (user == null || !user.getPassword().equals(password))
			throw new AuthenticationException("User failed to login");
		return user;
	}
}
