package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.View;
import boundary.action.views.EnquiryListingView;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;
import model.Query;
/*
 * ViewEnquiriesSuperAction is a class that is used to view all enquiries.
 */

public class ViewEnquiriesSuperAction extends Action {
	private final Camp camp;
	private List<Query> queries;
	/*
	 * Constructor for ViewEnquiriesSuperAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 */

	public ViewEnquiriesSuperAction(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "View All Enquiries".
	 */
	public String getDescription() {
		return "View All Enquiries";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		queries = context.getQueryManager()
				.getQueryByCamp(camp.getID());
	}

	@Override

	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public View getNextView() {
		return new EnquiryListingView(context, session, camp, queries);
	}

	@Override
	/*
	 * Get the required permissions.
	 * 
	 * @return The required permissions.
	 */
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.RESOLVE_ENQUIRY, Permission.VIEW_ENQUIRIES);
	}

}
