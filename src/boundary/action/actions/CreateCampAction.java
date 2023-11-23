package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.ModifyCampView;
import boundary.login.UserSession;
import boundary.util.CampCreator;
import main.Context;
import model.Camp;
import model.CampInfo;
import model.Permission;

public class CreateCampAction extends Action {
	private Camp camp;
	
	public CreateCampAction(Context context, UserSession session) {
		super(context, session);
	}

	@Override
	public String getDescription() { return "Create New Camp"; }

	@Override
	public void performAction() throws Exception {
		CampInfo campInfo = new CampCreator(context, session.getUser()).build();
		camp = context.getCampManager().createCamp(campInfo);
	}
	
	@Override
	public ViewHandler getNextView() {
		return new ModifyCampView(context, session, camp);
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMPS_SUPER, Permission.CREATE_CAMP);
	}
}