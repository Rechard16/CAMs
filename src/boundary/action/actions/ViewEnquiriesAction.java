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
 * ViewEnquiriesAction is a class that is used to view enquiries.
 */

public class ViewEnquiriesAction extends Action {
	private final Camp camp;
	private List<Query> queries;
	/*
	 * Constructor for ViewEnquiriesAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 */

	public ViewEnquiriesAction(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "View My Enquiries".
	 */
	public String getDescription() {
		return "View My Enquiries";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		queries = context.getQueryManager()
				.getQueryByCamp(camp.getID(), session.getUser().getID());
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
		return List.of(Permission.ENQUIRY);
	}

}
