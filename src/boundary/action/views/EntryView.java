package boundary.action.views;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.actions.ChangePasswordAction;
import boundary.action.actions.CreateCampAction;
import boundary.action.actions.DisplayPointsAction;
import boundary.action.actions.ExitAction;
import boundary.action.actions.ViewAssignedCampAction;
import boundary.action.actions.ViewCampsAction;
import boundary.action.actions.ViewMyCampsAction;
import boundary.action.actions.ViewSuperCampsAction;
import control.login.UserSession;
import entity.model.Permission;
import main.Context;

public class EntryView extends ViewHandler {
	/*
	 * Constructor for EntryView.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 */

	public EntryView(Context context, UserSession session) {
		super(context, session);
	}

	@Override
	/*
	 * Get the prompt.
	 * 
	 * @return "What do you want to do?".
	 */
	protected String getPrompt() {
		return "What do you want to do?";
	}

	@Override
	/*
	 * Generates the actions.
	 * 
	 * @return The actions.
	 */
	protected List<Action> generateActions() {
		return List.of(
				new ViewSuperCampsAction(context, session),
				new ViewCampsAction(context, session),
				new ViewMyCampsAction(context, session),
				new ViewAssignedCampAction(context, session),
				new DisplayPointsAction(context, session, this),
				new CreateCampAction(context, session),
				new ChangePasswordAction(context, session),
				new ExitAction(context, session));
	}

	@Override
	/*
	 * Get the permissions.
	 * 
	 * @return The permissions.
	 */
	protected List<Permission> getPermissions() {
		return this.context.getPermissionManager()
				.getPermissions(this.session.getUser());
	}

}
