package boundary.action.actions.filter;

import java.util.List;

import boundary.action.Action;
import boundary.action.View;
import boundary.action.views.CampFilterView;
import control.login.UserSession;
import entity.model.Camp;
import entity.model.Permission;
import main.Context;

public class CampFilterByAction extends Action {
	private List<Camp> items;
	/*
	 * Constructor for CampFilterByAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param items The items to be used.
	 */

	public CampFilterByAction(Context context, UserSession session, List<Camp> items) {
		super(context, session);
		this.items = items;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Filter by...".
	 */
	public String getDescription() {
		return "Filter by...";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		context.print("Creating filter!");
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public View getNextView() {
		return new CampFilterView(context, session, items);
	}

	@Override
	/*
	 * Get the required permissions.
	 * 
	 * @return The required permissions.
	 */
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMPS);
	}
}
