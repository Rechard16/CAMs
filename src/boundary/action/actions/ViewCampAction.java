package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.CampOptionsView;
import control.login.UserSession;
import entity.model.Camp;
import entity.model.Permission;
import entity.model.Role;
import main.Context;

public class ViewCampAction extends Action {
	private Camp camp;
	/*
	 * Constructor for ViewCampAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 */

	public ViewCampAction(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
	}
	/*
	 * Constructor for ViewCampAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 */

	public ViewCampAction(Context context, UserSession session) {
		super(context, session);
	}
	/*
	 * Set the camp.
	 * 
	 * @param camp The camp to be used.
	 */

	protected void setCamp(Camp camp) {
		this.camp = camp;
	}
	/*
	 * Get the camp.
	 * 
	 * @return The camp.
	 */

	protected Camp getCamp() {
		return this.camp;
	}

	@Override
	/*
	 * Get the prompt.
	 * 
	 * @return "How will you handle this suggestion?:".
	 */
	public String getDescription() {
		String name = camp.getInformation().getName();

		Role role = session.getUser().getRole(camp);
		if (role != Role.FREE_VIEWER && role != Role.VIEWER && role != Role.STAFF)
			name += String.format(" (%s)", role.name());

		if (!camp.getVisibility())
			name += " (Hidden)";
		return name;
	}

	@Override
	/*
	 * Generates the actions.
	 * 
	 * @return The actions.
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
		return new CampOptionsView(context, session, camp);
	}

	@Override
	/*
	 * Get the required permissions.
	 * 
	 * @return The required permissions.
	 */
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMP);
	}

}
