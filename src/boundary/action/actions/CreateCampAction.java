package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import boundary.util.CampCreator;
import main.Context;
import model.Camp;
import model.CampInfo;
import model.Permission;
/*
 * CreateCampAction is a class that is used to create a camp.
 */

public class CreateCampAction extends Action {
	private Camp camp;
	/*
	 * Constructor for CreateCampAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 */

	public CreateCampAction(Context context, UserSession session) {
		super(context, session);
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Create New Camp".
	 */
	public String getDescription() {
		return "Create New Camp";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		CampInfo campInfo = new CampCreator(context, session.getUser()).build();
		camp = context.getCampManager().createCamp(campInfo);
		context.print("New camp created! Unhide it to allow students to sign up.");
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public ViewHandler getNextView() {
		return session.getViewStack().reset();
	}

	@Override
	/*
	 * Get the required permissions.
	 * 
	 * @return The required permissions.
	 */
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMPS_SUPER, Permission.CREATE_CAMP);
	}
}