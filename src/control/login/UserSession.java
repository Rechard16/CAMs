package control.login;

import boundary.action.ActionAuthorizer;
import entity.model.User;

public class UserSession {
	private final LoginSession loginSession;
	private final ViewStack viewStack;
	private final ActionAuthorizer authorizer;
	/*
	 * Constructor for UserSession.
	 * 
	 * @param loginSession The login session to be used.
	 */

	public UserSession(LoginSession loginSession) {
		this.loginSession = loginSession;
		this.viewStack = new ViewStack();
		this.authorizer = new ActionAuthorizer(loginSession);
	}
	/*
	 * Gets the user.
	 * 
	 * @return The user.
	 */

	public User getUser() {
		return this.loginSession.getUser();
	}
	/*
	 * Gets the login session.
	 * 
	 * @return The login session.
	 */

	public LoginSession getLoginSession() {
		return this.loginSession;
	}
	/*
	 * Gets the view stack.
	 * 
	 * @return The view stack.
	 */

	public ViewStack getViewStack() {
		return this.viewStack;
	}
	/*
	 * Gets the authorizer.
	 * 
	 * @return The authorizer.
	 */

	public ActionAuthorizer getAuthorizer() {
		return this.authorizer;
	}
}
