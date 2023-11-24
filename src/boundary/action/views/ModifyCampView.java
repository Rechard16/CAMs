package boundary.action.views;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.actions.ApplyChangesAction;
import boundary.action.actions.CancelChangesAction;
import boundary.action.actions.PrintCampAction;
import boundary.action.actions.ToggleVisibilityAction;
import boundary.action.actions.modification.NameModificationAction;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.CampInfoModifier;
import model.Permission;

public class ModifyCampView extends ViewHandler {
	private final Camp camp;
	private final CampInfoModifier modifier = new CampInfoModifier();
	
	public ModifyCampView(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp=camp;
	}

	@Override
	protected String getPrompt() {
		return "Modifications to this camp:";
	}

	@Override
	protected List<Action> generateActions() {
		return List.of(
				new PrintCampAction(context, session, camp, modifier),
				new NameModificationAction(context, session, modifier),
				new ToggleVisibilityAction(context, session, camp),
				new ApplyChangesAction(context, session, camp, modifier),
				new CancelChangesAction(context, session)
				);
	}

	@Override
	protected List<Permission> getPermissions() {
		return context.getPermissionManager()
				.getCampModificationPermissions(this.session.getUser(), camp);
	}


}