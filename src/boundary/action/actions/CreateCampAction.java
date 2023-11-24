package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
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
		context.print("New camp created! Unhide it to allow students to sign up.");
	}
	
	@Override
	public ViewHandler getNextView() {
		return session.getViewStack().reset();
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMPS_SUPER, Permission.CREATE_CAMP);
	}
}