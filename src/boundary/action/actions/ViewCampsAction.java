package boundary.action.actions;

import java.io.IOException;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.CampListingView;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;
/*
 * ViewCampsAction is a class that is used to view camps.
 */

public class ViewCampsAction extends Action {

	private List<Camp> camps;
	/*
	 * Constructor for ViewCampsAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 */

	public ViewCampsAction(Context context, UserSession session) {
		super(context, session);
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "View Camps in my Faculty".
	 */
	public String getDescription() {
		return "View Camps in my Faculty";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws ClassNotFoundException, IOException {
		camps = context.getCampManager()
				.getCampsByEligibility(session.getUser().getFaculty());
		;
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public ViewHandler getNextView() {
		return new CampListingView(context, session, camps);
	}

	@Override
	/*
	 * Get the required permissions.
	 * 
	 * @return The required permissions.
	 */
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMPS, Permission.VIEW_CAMP);
	}

}
