package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.ModifyCampView;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;
import model.UserType;

public class ModifyCampAction extends Action {
	private final Camp camp;

	public ModifyCampAction(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
	}

	@Override
	public String getDescription() {
		if (session.getUser().getType() == UserType.STUDENT)
			return "Suggest changes to this camp";
		return "Modify this Camp";
	}

	@Override
	public void performAction() throws Exception {}
	
	@Override
	public ViewHandler getNextView() {
		return new ModifyCampView(context, session, camp);
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.MODIFY_CAMP, Permission.VIEW_CAMP);
	}

}
