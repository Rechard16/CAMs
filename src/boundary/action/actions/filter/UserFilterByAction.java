package boundary.action.actions.filter;

import java.util.List;

import boundary.action.Action;
import boundary.action.View;
import boundary.action.views.UserFilterView;
import control.login.UserSession;
import entity.model.Camp;
import entity.model.Permission;
import main.Context;

public class UserFilterByAction extends Action {
	private final Camp camp;
	/*
	 * Constructor for CampFilterByAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param items The items to be used.
	 */

	public UserFilterByAction(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Filter by...".
	 */
	public String getDescription() {
		return "Create Report";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public View getNextView() {
		return new UserFilterView(context, session, camp);
	}

	@Override
	/*
	 * Get the required permissions.
	 * 
	 * @return The required permissions.
	 */
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMP, Permission.GENERATE_REPORT);
	}

}
