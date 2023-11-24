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

public class ViewCampsAction extends Action{
	
	private List<Camp> camps;
	
	public ViewCampsAction(Context context, UserSession session) {
		super(context, session);
	}

	@Override
	public String getDescription() { return "View Camps in my Faculty"; }

	@Override
	public void performAction() throws ClassNotFoundException, IOException {
		camps = context.getCampManager()
			.getCampsByEligibility(session.getUser().getFaculty());;
	}

	@Override
	public ViewHandler getNextView() {
		return new CampListingView(context, session, camps);
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMPS, Permission.VIEW_CAMP);
	}

}
