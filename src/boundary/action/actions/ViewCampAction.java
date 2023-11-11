package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.EntryView;
import boundary.login.LoginSession;
import main.Context;
import model.Camp;
import model.Permission;

public class ViewCampAction implements Action {
	private final Context context;
	private final LoginSession session;
	private final Camp camp;

	public ViewCampAction(Context context, LoginSession session, Camp camp) {
		this.context = context;
		this.session = session;
		this.camp = camp;
	}
	
	@Override
	public String getDescription() {
		return camp.getInformation().getName();
	}

	@Override
	public void performAction() throws Exception {
		context.print("You have selected: %s\n", camp.getInformation().getName());
	}

	@Override
	public ViewHandler getNextView() {
		return new EntryView(context, session);
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMP);
	}

}
