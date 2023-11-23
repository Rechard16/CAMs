package boundary.login;

import boundary.action.ActionAuthorizer;
import model.User;

public class UserSession {
	private final LoginSession loginSession;
	private final ViewStack viewStack;
	private final ActionAuthorizer authorizer;

	public UserSession(LoginSession loginSession) {
		this.loginSession = loginSession;
		this.viewStack = new ViewStack();
		this.authorizer = new ActionAuthorizer(loginSession);
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
	
	public ActionAuthorizer getAuthorizer() {
		return this.authorizer;
	}
}
