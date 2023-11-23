package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import boundary.util.RegistrationHandler;
import main.Context;
import model.Camp;
import model.Permission;

public class RegisterAction extends Action {
	private final Camp camp;
	private ViewHandler viewHandler;

	public RegisterAction(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
	}

	@Override
	public String getDescription() {
		return "Register as Participant";
	}

	@Override
	public void performAction() throws Exception {
		try {
			RegistrationHandler handler = new RegistrationHandler(context, 
											session.getUser(), camp, false);
			handler.register();
		} catch (Exception e) {
			context.print("Could not register as a participant!");
			context.print(e.getMessage());
			viewHandler = session.getViewStack().top();
			return;
		}
		
		context.print("Successfully registered as a participant!");
		viewHandler = session.getViewStack().reset();
	}
	
	@Override
	public ViewHandler getNextView() {
		return viewHandler;
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMP, Permission.REGISTER);
	}

}
