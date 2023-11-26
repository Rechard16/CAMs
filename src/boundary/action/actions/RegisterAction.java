package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import control.event.RegistrationHandler;
import control.login.UserSession;
import entity.model.Camp;
import entity.model.Permission;
import main.Context;

public class RegisterAction extends Action {
	private final Camp camp;
	private ViewHandler viewHandler;
	/*
	 * Constructor for RegisterAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 */

	public RegisterAction(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Register as Participant".
	 */
	public String getDescription() {
		return "Register as Participant";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
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
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public ViewHandler getNextView() {
		return viewHandler;
	}

	@Override
	/*
	 * Get the required permissions.
	 * 
	 * @return The required permissions.
	 */
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMP, Permission.REGISTER);
	}

}
