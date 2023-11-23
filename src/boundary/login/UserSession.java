package boundary.login;

import model.User;

public class UserSession {
	private final LoginSession loginSession;
	private final ViewStack viewStack;

	public UserSession(LoginSession loginSession) {
		this.loginSession = loginSession;
		viewStack = new ViewStack();
	}
	
	public User getUser() {
		return this.loginSession.getUser();
	}
	
	public LoginSession getLoginSession() {
		return this.loginSession;
	}
	
	public ViewStack getViewStack() {
		return this.viewStack;
	}
}
