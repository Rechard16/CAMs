package boundary.action.views;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.actions.ApplyChangesAction;
import boundary.action.actions.CancelChangesAction;
import boundary.action.actions.RejectSuggestionAction;
import boundary.display.CampDisplayer;
import control.login.UserSession;
import entity.model.Camp;
import entity.model.Permission;
import entity.model.Suggestion;
import entity.model.change.Change;
import main.Context;

public class SuggestionView extends ViewHandler {
	private final Camp camp;
	private final Suggestion suggestion;
	/*
	 * Constructor for SuggestionView.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 * 
	 * @param suggestion The suggestion to be used.
	 */

	public SuggestionView(Context context, UserSession session, Camp camp, Suggestion suggestion) {
		super(context, session);
		this.camp = camp;
		this.suggestion = suggestion;
	}

	@Override
	/*
	 * Get the prompt.
	 * 
	 * @return "How will you handle this suggestion?:".
	 */
	protected String getPrompt() {
		return "How will you handle this suggestion?:";
	}

	@Override
	/*
	 * Displays the view.
	 * 
	 * @throws Exception
	 */
	public void displayView() throws Exception {
		new CampDisplayer(context, camp).display();
		context.print("\nSuggested Modifications to this Camp:");
		for (Change change : suggestion.getModifier().getChanges()) {
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
	protected List<Action> generateActions() throws Exception {
		return List.of(
				new ApplyChangesAction(context, session, camp, suggestion),
				new RejectSuggestionAction(context, session, suggestion),
				new CancelChangesAction(context, session));
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