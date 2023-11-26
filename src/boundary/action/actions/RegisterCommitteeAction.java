package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import boundary.util.RegistrationHandler;
import main.Context;
import model.Camp;
import model.Permission;
/*
 * RegisterCommitteeAction is a class that is used to register as a committee member.
 */

public class RegisterCommitteeAction extends Action {
	private final Camp camp;
	private ViewHandler viewHandler;
	/*
	 * Constructor for RegisterCommitteeAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 */

	public RegisterCommitteeAction(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Register as Committee Member".
	 */
	public String getDescription() {
		return "Register as Committee Member";
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
		return List.of(Permission.VIEW_CAMP, Permission.REGISTER, Permission.REGISTER_COMMITTEE);
	}

}
