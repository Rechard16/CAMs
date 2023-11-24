package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.CampListingView;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;

public class ViewMyCampsAction extends Action {
	private List<Camp> camps;
	
	public ViewMyCampsAction(Context context, UserSession session) {
		super(context, session);
	}

	@Override
	public String getDescription() { return "View My Camps"; }

	@Override
	public void performAction() throws Exception {
		camps = context.getCampManager().getRegisteredCamps(session.getUser());
	}

	@Override
	public ViewHandler getNextView() {
		return new CampListingView(context, session, camps);
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMP, Permission.VIEW_CAMPS);
	}

}
