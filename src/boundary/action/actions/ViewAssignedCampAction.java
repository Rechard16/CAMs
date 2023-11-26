package boundary.action.actions;

import java.util.ArrayList;
import java.util.List;

import boundary.action.ViewHandler;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;
import model.Student;
/*
 * ViewAssignedCampAction is a class that is used to view an assigned camp.
 */

public class ViewAssignedCampAction extends ViewCampAction {
	private ViewHandler nextView;
	/*
	 * Constructor for ViewAssignedCampAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 */

	public ViewAssignedCampAction(Context context, UserSession session) {
		super(context, session);
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "View Assigned Camp".
	 */
	public String getDescription() {
		return "View Assigned Camp";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		Student student = (Student) session.getUser();
		int id = student.getCampID();
		if (id == -1) {
			context.print("You do not have an assigned camp!");
			nextView = session.getViewStack().top();
			return;
		}
		Camp camp = context.getCampManager().getCampByID(id);

		this.setCamp(camp);
		super.performAction();
		nextView = super.getNextView();

	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public ViewHandler getNextView() {
		return nextView;
	}

	@Override
	/*
	 * Get the required permissions.
	 * 
	 * @return The required permissions.
	 */
	public List<Permission> getRequiredPermissions() {
		List<Permission> perms = new ArrayList<>();
		perms.addAll(super.getRequiredPermissions());
		perms.add(Permission.COMMITTEE_ELIGIBLE);
		return perms;
	}
}
