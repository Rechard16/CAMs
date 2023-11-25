package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import main.Context;
import model.Permission;
import model.Suggestion;

/*
 * RejectSuggestionAction is a class that is used to reject a suggestion.
 */
public class RejectSuggestionAction extends Action {
	private final Suggestion suggestion;
	/*
	 * Constructor for RejectSuggestionAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param suggestion The suggestion to be used.
	 */

	public RejectSuggestionAction(Context context, UserSession session, Suggestion suggestion) {
		super(context, session);
		this.suggestion = suggestion;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Reject these Suggestions".
	 */
	public String getDescription() {
		return "Reject these Suggestions";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		try {
			suggestion.close();
			context.getSuggestionManager().save();
		} catch (Exception e) {
			context.print("I/O Error. Failed to delete suggestion!");
			return;
		}
		context.print("Suggestion has been removed.");
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.MODIFY_CAMP, Permission.APPROVE_SUGGEST);
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public ViewHandler getNextView() {
		return session.getViewStack().pop(2);
	}
}
