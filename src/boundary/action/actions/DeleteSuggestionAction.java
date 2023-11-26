package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.View;
import control.login.UserSession;
import entity.model.Permission;
import entity.model.Suggestion;
import main.Context;

public class DeleteSuggestionAction extends Action {
	private final Suggestion suggestion;
	/*
	 * Constructor for DeleteSuggestionAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param suggestion The suggestion to be used.
	 */

	public DeleteSuggestionAction(Context context, UserSession session, Suggestion suggestion) {
		super(context, session);
		this.suggestion = suggestion;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Delete this Suggestion".
	 */
	public String getDescription() {
		return "Delete this Suggestion";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		context.getSuggestionManager().deleteSuggestion(suggestion);
		context.print("Your suggestion was deleted!");
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public View getNextView() {
		return session.getViewStack().pop(2);
	}

	@Override
	/*
	 * Get the required permissions.
	 * 
	 * @return The required permissions.
	 */
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.MODIFY_CAMP, Permission.SUGGEST_CAMP);
	}

}
