package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;
import model.User;
/*
 * DeleteCampAction is a class that is used to delete camps.
 */

public class DeleteCampAction extends Action {
	private final Camp camp;
	/*
	 * Constructor for DeleteCampAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 */

	public DeleteCampAction(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Delete this Camp".
	 */
	public String getDescription() {
		return "Delete this Camp";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		for (int id : camp.getStudents()) {
			User user = context.getUserManager().getUserByID(id);
			user.deregister(camp);
		}
		context.getCampManager().deleteCamp(camp);

		context.print("Your camp was deleted!");
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.DELETE_CAMP);
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
}
