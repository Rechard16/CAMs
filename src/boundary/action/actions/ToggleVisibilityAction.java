package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;

public class ToggleVisibilityAction extends Action {
	private final Camp camp;

	public ToggleVisibilityAction(Context context, UserSession session, Camp camp) {
		super(context, session);
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
		try {
			context.getCampManager().save();
		} catch (Exception e) { 
			context.print("I/O Error. Unable to save your changes!");
		}
		context.print("The visibility of this camp has been set to: %s\n",
				visibility?"false":"true");
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMP, Permission.TOGGLE_VISIBILITY);
	}

}
