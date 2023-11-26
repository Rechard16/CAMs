package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import control.login.UserSession;
import entity.model.Camp;
import entity.model.Permission;
import main.Context;

public class ToggleVisibilityAction extends Action {
	private final Camp camp;
	/*
	 * Constructor for ToggleVisibilityAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 */

	public ToggleVisibilityAction(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Toggle Visibility of Camp".
	 */
	public String getDescription() {
		return "Toggle Visibility of Camp";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		boolean visibility = camp.getVisibility();
		camp.setVisibility(!visibility);
		try {
			context.getCampManager().save();
		} catch (Exception e) {
			context.print("I/O Error. Unable to save your changes!");
		}
		context.print("The visibility of this camp has been set to: %s\n",
				visibility ? "false" : "true");
	}

	@Override
	/*
	 * Get the required permissions.
	 * 
	 * @return A list of permissions.
	 */
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMP, Permission.TOGGLE_VISIBILITY);
	}

}
