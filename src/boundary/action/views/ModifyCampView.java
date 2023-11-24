package boundary.action.views;

import java.util.ArrayList;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.actions.ApplyChangesAction;
import boundary.action.actions.CancelChangesAction;
import boundary.action.actions.SubmitSuggestionAction;
import boundary.action.actions.modification.ModificationAction;
import boundary.display.CampDisplayer;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.CampInfoModifier;
import model.Permission;
import model.change.Change;

public class ModifyCampView extends ViewHandler {
	private final Camp camp;
	private final CampInfoModifier modifier;

	public ModifyCampView(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
		this.modifier = new CampInfoModifier();
	}

	@Override
	protected String getPrompt() {
		return "How will you modify this camp?";
	}

	@Override
	public void displayView() throws Exception {
		new CampDisplayer(context, camp).display();
		context.print("\nCurrent Modifications to this Camp:");
		for (Change change : modifier.getChanges()) {
			context.print("- " + change.getDescription());
		}
		super.displayView();
	}

	@Override
	protected List<Action> generateActions() {
		List<Action> actions = new ArrayList<>();
		actions.addAll(ModificationAction
				.getModificationActions(context, session, modifier));
		actions.addAll(List.of(
				// new ToggleVisibilityAction(context, session, camp),
				new SubmitSuggestionAction(context, session, camp, modifier),
				new ApplyChangesAction(context, session, camp, modifier, true),
				new CancelChangesAction(context, session)
				));
		return actions;
	}

	@Override
	protected List<Permission> getPermissions() {
		return context.getPermissionManager()
				.getCampModificationPermissions(this.session.getUser(), camp);
	}
}
