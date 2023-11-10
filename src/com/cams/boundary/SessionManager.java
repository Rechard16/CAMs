package boundary;

import main.Context;

public class SessionManager {
	
	private final Context context;
	private final LoginSession loginSession;
	
	public SessionManager(Context context, LoginSession session) {
		this.context = context;
		this.loginSession = session;
	}

	public void startSession() {
		context.print("Successfully logged in as %s.", loginSession.getUserId());
		context.print("Welcome to CAMS!");
	}
}
