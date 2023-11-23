package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;

public class ToggleVisibilityAction implements Action {
	private final Context context;
	private final UserSession session;
	private final Camp camp;

	public ToggleVisibilityAction(Context context, UserSession session, Camp camp) {
		this.context = context;
		this.session = session;
		this.camp = camp;
	}

	@Override
	public String getDescription() {
		return "Toggle Visibility of Camp";
	}

	@Override
	public void performAction() throws Exception {
		boolean visibility = camp.getVisibility();
		camp.setVisibility(!visibility);
		context.print("The visibility of this camp has been set to: %s\n",
				visibility?"false":"true");
	}

	@Override
	public ViewHandler getNextView() {
		return session.getViewStack().top();
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMP, Permission.TOGGLE_VISIBILITY);
	}

}
