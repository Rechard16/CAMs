package boundary.action.actions;

import java.io.IOException;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.CampListingView;
import control.login.UserSession;
import entity.model.Camp;
import entity.model.Permission;
import main.Context;

public class ViewSuperCampsAction extends Action {

	private List<Camp> camps;

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "View All Camps in System".
	 */
	public String getDescription() {
		return "View All Camps in System";
	}
	/*
	 * Constructor for ViewSuperCampsAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 */

	public ViewSuperCampsAction(Context context, UserSession session) {
		super(context, session);
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws ClassNotFoundException, IOException {
		camps = context.getCampManager()
				.getAllCamps();
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
		return List.of(Permission.VIEW_CAMPS_SUPER, Permission.VIEW_CAMP);
	}

}
