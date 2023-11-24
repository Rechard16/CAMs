package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;
import model.User;

public class DeleteCampAction extends Action {
	private final Camp camp;

	public DeleteCampAction(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
	}

	@Override
	public String getDescription() {
		return "Delete this Camp";
	}

	@Override
	public void performAction() throws Exception {
		for (int id : camp.getStudents()) {
			User user = context.getUserManager().getUserByID(id);
			user.deregister(camp);
		}
		context.getCampManager().deleteCamp(camp);
		
		context.print("Your camp was deleted!");
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.DELETE_CAMP);
	}

	@Override
	public ViewHandler getNextView() {
		return session.getViewStack().reset();
	}
}
