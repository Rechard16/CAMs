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
import boundary.display.CampDisplayer;
import control.login.UserSession;
import entity.model.Camp;
import entity.model.CampInfoModifier;
import entity.model.Permission;
import entity.model.Suggestion;
import entity.model.SuggestionStatus;
import entity.model.change.Change;
import main.Context;

public class ModifySuggestionView extends ViewHandler {
	private final Camp camp;
	private final CampInfoModifier modifier;
	private final Suggestion suggestion;
	/*
	 * Constructor for ModifySuggestionView.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 * 
	 * @param suggestion The suggestion to be used.
	 */

	public ModifySuggestionView(Context context, UserSession session,
			Camp camp, Suggestion suggestion) {
		super(context, session);
		this.camp = camp;
		this.suggestion = suggestion;
		this.modifier = new CampInfoModifier(suggestion.getModifier());
	}

	@Override
	/*
	 * Get the prompt.
	 * 
	 * @return "How will you modify this suggestion?".
	 */
	protected String getPrompt() {
		return "How will you modify this suggestion?";
	}

	@Override
	/*
	 * Displays the view.
	 * 
	 * @throws Exception
	 */
	public void displayView() throws Exception {
		new CampDisplayer(context, camp).display();
		context.print("\nModifications to this Camp:");
		for (Change change : modifier.getChanges()) {
			context.print("- " + change.getDescription());
		}
		super.displayView();
	}

	@Override
	/*
	 * Generates the actions.
	 * 
	 * @return The actions.
	 */
	protected List<Action> generateActions() {
		List<Action> actions = new ArrayList<>();
		if (suggestion.getStatus() == SuggestionStatus.OPEN) {
			actions.addAll(ModificationAction
					.getModificationActions(context, session, modifier));
			actions.addAll(List.of(
					new UpdateSuggestionAction(context, session, camp, modifier, suggestion),
					new ConfirmationAction(context, session,
							new DeleteSuggestionAction(context, session, suggestion)),
					new CancelChangesAction(context, session)));
		} else {
			actions.add(new PreviousViewAction(context, session));
		}
		return actions;
	}

	@Override
	/*
	 * Get the permissions.
	 * 
	 * @return The permissions.
	 */
	protected List<Permission> getPermissions() {
		return context.getPermissionManager()
				.getCampModificationPermissions(this.session.getUser(), camp);
	}
}