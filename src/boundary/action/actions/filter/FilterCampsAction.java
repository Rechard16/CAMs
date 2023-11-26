package boundary.action.actions.filter;

import java.util.List;

import boundary.action.Action;
import boundary.action.View;
import boundary.action.views.CampListingView;
import boundary.filter.Filter;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;
/*
 * FilterCampsAction is a class that is used to filter camps.
 */

public class FilterCampsAction extends Action {
	private final Filter<Camp> filter;
	private List<Camp> camps;
	/*
	 * Constructor for FilterCampsAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param filter The filter to be used.
	 * 
	 * @param camps The camps to be used.
	 */

	public FilterCampsAction(Context context, UserSession session,
			Filter<Camp> filter, List<Camp> camps) {
		super(context, session);
		this.filter = filter;
		this.camps = camps;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Search with current filter".
	 */
	public String getDescription() {
		return "Search with current filter";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		camps = filter.getValid(context, camps);
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public View getNextView() {
		return new CampListingView(context, session, camps);
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
