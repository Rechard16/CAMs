package boundary.action.views;

import java.util.ArrayList;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.actions.CancelChangesAction;
import boundary.action.actions.ConfirmationAction;
import boundary.action.actions.DeleteSuggestionAction;
import boundary.action.actions.PreviousViewAction;
import boundary.action.actions.UpdateSuggestionAction;
import boundary.action.actions.modification.ModificationAction;
import boundary.login.UserSession;
import boundary.util.CampDisplayer;
import main.Context;
import model.Camp;
import model.CampInfoModifier;
import model.Change;
import model.Permission;
import model.Suggestion;
import model.SuggestionStatus;

public class ModifySuggestionView extends ViewHandler {
	private final Camp camp;
	private final CampInfoModifier modifier;
	private final Suggestion suggestion;

	public ModifySuggestionView(Context context, UserSession session, 
		Camp camp, Suggestion suggestion) {
		super(context, session);
		this.camp = camp;
		this.suggestion = suggestion;
		this.modifier = new CampInfoModifier(suggestion.getModifier());
	}

	@Override
	protected String getPrompt() {
		return "How will you modify this suggestion?";
	}

	@Override
	public void displayView() throws Exception {
		new CampDisplayer(context, camp).dislayCamp();
		context.print("\nModifications to this Camp:");
		for (Change change : modifier.getChanges()) {
			context.print("- " + change.getDescription());
		}
		super.displayView();
	}

	@Override
	protected List<Action> generateActions() {
		List<Action> actions = new ArrayList<>();
		if (suggestion.getStatus() == SuggestionStatus.OPEN) {
			actions.addAll(ModificationAction
					.getModificationActions(context, session, modifier));
			actions.addAll(List.of(
					new UpdateSuggestionAction(context, session, camp, modifier,suggestion),
					new ConfirmationAction(context, session,
							new DeleteSuggestionAction(context, session, suggestion)),
					new CancelChangesAction(context, session)
					));
		} else {
			actions.add(new PreviousViewAction(context, session));
		}
		return actions;
	}

	@Override
	protected List<Permission> getPermissions() {
		return context.getPermissionManager()
				.getCampModificationPermissions(this.session.getUser(), camp);
	}
}