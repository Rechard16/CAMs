package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.EntryView;
import boundary.login.LoginSession;
import main.Context;
import model.Permission;

public class ViewSuperCampsAction implements Action{
	
	private final Context context;
	private final LoginSession session;

	@Override
	public String getDescription() {
		return "View All Camps";
	}
	
	public ViewSuperCampsAction(Context context, LoginSession session) {
		this.context = context;
		this.session = session;
	}

	@Override
	public void performAction() {
		context.print("Hehehaha");
	}

	@Override
	public ViewHandler getNextView() {
		return new EntryView(context, session);
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMPS_SUPER, Permission.VIEW_CAMP);
	}

}
