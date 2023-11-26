package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.ModifyCampView;
import control.login.UserSession;
import entity.model.Camp;
import entity.model.Permission;
import entity.model.UserType;
import main.Context;

public class ModifyCampAction extends Action {
	private final Camp camp;
	/*
	 * Constructor for ModifyCampAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 */

	public ModifyCampAction(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Modify this Camp".
	 */
	public String getDescription() {
		if (session.getUser().getType() == UserType.STUDENT)
			return "Suggest changes to this camp";
		return "Modify this Camp";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public ViewHandler getNextView() {
		return new ModifyCampView(context, session, camp);
	}

	@Override
	/*
	 * Get the required permissions.
	 * 
	 * @return The required permissions.
	 */
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.MODIFY_CAMP, Permission.VIEW_CAMP);
	}

}
