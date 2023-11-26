package boundary.action.views;

import java.util.ArrayList;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.actions.ModifySuggestionAction;
import boundary.action.actions.PreviousViewAction;
import boundary.action.actions.ViewSuggestionAction;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;
import model.Suggestion;
/*
 * SuggestionListingView is a class that is used to list suggestions.
 */

public class SuggestionListingView extends ViewHandler {
	private final Camp camp;
	private final List<Suggestion> suggestions;
	/*
	 * Constructor for SuggestionListingView.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 * 
	 * @param suggestions The suggestions to be used.
	 */

	public SuggestionListingView(Context context, UserSession session,
			Camp camp, List<Suggestion> suggestions) {
		super(context, session);
		this.camp = camp;
		this.suggestions = suggestions;
	}

	@Override
	/*
	 * Get the prompt.
	 * 
	 * @return "Which suggestion do you wish to view?".
	 */
	protected String getPrompt() {
		return "Which suggestion do you wish to view?";
	}

	@Override
	/*
	 * Generates the actions.
	 * 
	 * @return The actions.
	 */
	protected List<Action> generateActions() throws Exception {
		List<Action> actions = new ArrayList<>();
		for (Suggestion s : suggestions) {
			actions.add(new ViewSuggestionAction(context, session, camp, s));
			actions.add(new ModifySuggestionAction(context, session, camp, s));
		}
		actions.add(new PreviousViewAction(context, session));
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
