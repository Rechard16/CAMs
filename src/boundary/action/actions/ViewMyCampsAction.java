package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.CampListingView;
import control.login.UserSession;
import entity.model.Camp;
import entity.model.Permission;
import main.Context;

public class ViewMyCampsAction extends Action {
	private List<Camp> camps;
	/*
	 * Constructor for ViewMyCampsAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 */

	public ViewMyCampsAction(Context context, UserSession session) {
		super(context, session);
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "View My Camps".
	 */
	public String getDescription() {
		return "View My Camps";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		camps = context.getCampManager().getRegisteredCamps(session.getUser());
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
		return List.of(Permission.VIEW_CAMP, Permission.VIEW_CAMPS);
	}

}
