package boundary.action.views;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.actions.ChangePasswordAction;
import boundary.action.actions.DisplayPointsAction;
import boundary.action.actions.ExitAction;
import boundary.action.actions.ViewAssignedCampAction;
import boundary.action.actions.ViewCampsAction;
import boundary.action.actions.ViewCreatedCampsAction;
import boundary.action.actions.ViewSuperCampsAction;
import boundary.login.UserSession;
import main.Context;
import model.Permission;

public class EntryView extends ViewHandler {

	public EntryView(Context context, UserSession session) {
		super(context, session);
	}

	@Override
	protected String getPrompt() { return "What do you want to do?"; }

	@Override
	protected List<Action> generateActions() {
		return List.of(
				new ViewCampsAction(context, session),
				new ViewAssignedCampAction(context, session),
				new ViewCreatedCampsAction(context, session),
				new ViewSuperCampsAction(context, session),
				new DisplayPointsAction(context, session, this),
				new ChangePasswordAction(context, session),
				new ExitAction(context, session)
				);
	}

	@Override
	protected List<Permission> getPermissions() {
		return this.context.getPermissionManager()
				.getPermissions(this.session.getUser());
	}

}
