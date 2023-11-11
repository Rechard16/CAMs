package boundary.action.actions;

import java.io.IOException;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.CampListingView;
import boundary.login.LoginSession;
import main.Context;
import model.Camp;
import model.Permission;

public class ViewCampsAction implements Action{
	
	private final Context context;
	private final LoginSession session;
	private List<Camp> camps;
	
	public ViewCampsAction(Context context, LoginSession session) {
		this.context = context;
		this.session = session;
	}

	@Override
	public String getDescription() { return "View My Camps"; }

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
