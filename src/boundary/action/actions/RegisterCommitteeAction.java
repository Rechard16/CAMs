package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import boundary.util.RegistrationHandler;
import main.Context;
import model.Camp;
import model.Permission;

public class RegisterCommitteeAction extends Action{
	private final Camp camp;
	private ViewHandler viewHandler;

	public RegisterCommitteeAction(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
	}

	@Override
	public String getDescription() {
		return "Register as Committee Member";
	}

	@Override
	public void performAction() throws Exception {
		try {
			RegistrationHandler handler = new RegistrationHandler(context, 
											session.getUser(), camp, true);
			handler.register();
		} catch (Exception e) {
			context.print("Could not register as a committee member!");
			context.print(e.getMessage());
			viewHandler = session.getViewStack().top();
			return;
		}
		
		context.print("Successfully registered as a committee member!");
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
