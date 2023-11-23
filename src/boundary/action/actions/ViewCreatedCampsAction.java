package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.CampListingView;
import boundary.filter.FilterParameter;
import boundary.filter.camp.StaffParameter;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;

public class ViewCreatedCampsAction extends Action {
	private List<Camp> camps;
	
	public ViewCreatedCampsAction(Context context, UserSession session) {
		super(context, session);
	}

	@Override
	public String getDescription() { return "View Created Camps"; }

	@Override
	public void performAction() throws Exception {
		FilterParameter<Camp> filter = new StaffParameter(session.getUser().getID());
		camps = filter.doFilter(context.getCampManager().getAllCamps());
	}

	@Override
	public ViewHandler getNextView() {
		return new CampListingView(context, session, camps);
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMPS_SUPER, Permission.CREATE_CAMP);
	}

}
