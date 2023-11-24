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

public class ViewEnquiriesSuperAction extends Action {
	private final Camp camp;
	private List<Query> queries;

	public ViewEnquiriesSuperAction(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
	}

	@Override
	public String getDescription() {
		return "View All Enquiries";
	}

	@Override
	public void performAction() throws Exception {
		queries = context.getQueryManager()
				.getQueryByCamp(camp.getID());
	}
	
	@Override
	public View getNextView() {
		return new EnquiryListingView(context, session, camp, queries);
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.RESOLVE_ENQUIRY, Permission.VIEW_ENQUIRIES);
	}

}
