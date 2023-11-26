package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import main.Context;
import model.Permission;
import model.Student;
/*
 * DisplayPointsAction is a class that is used to display points.
 */

public class DisplayPointsAction extends Action {
	private final ViewHandler currentView;
	/*
	 * Constructor for DisplayPointsAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param currentView The current view to be used.
	 */

	public DisplayPointsAction(Context context, UserSession session, ViewHandler currentView) {
		super(context, session);
		this.currentView = currentView;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "View My Current Points".
	 */
	public String getDescription() {
		return "View My Current Points";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() {
		Student student = (Student) session.getUser();
		int points = student.getPoints();

		context.print("Your current points: %d\n", points);

		if (student.getCampID() == -1)
			context.print("You have not registered as a committee member for any camp!");
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.COMMITTEE_ELIGIBLE);
	}
}
