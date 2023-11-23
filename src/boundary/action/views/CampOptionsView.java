package boundary.action.views;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.actions.PreviousViewAction;
import boundary.action.actions.ToggleVisibilityAction;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;

public class CampOptionsView extends ViewHandler {
	private Camp camp;
	
	public CampOptionsView(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp=camp;
	}

	@Override
	protected String getPrompt() {
		return "What do you wish to do with this camp?";
	}

	@Override
	protected List<Action> generateActions() {
		return List.of(
				new ToggleVisibilityAction(context, session, camp),
				new PreviousViewAction(session)
				);
	}

	@Override
	protected List<Permission> getPermissions() {
		return context.getPermissionManager()
				.getCampModificationPermissions(this.session.getUser(), camp);
	}

}
