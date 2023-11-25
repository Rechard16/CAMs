package boundary.action.actions;

import java.io.IOException;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.SuggestionView;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;
import model.Suggestion;
import model.SuggestionStatus;
import model.User;
/*
 * ViewSuggestionAction is a class that is used to view a suggestion.
 */

public class ViewSuggestionAction extends Action {
	private final Suggestion suggestion;
	private final User user;
	private final Camp camp;
	/*
	 * Constructor for ViewSuggestionAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 * 
	 * @param suggestion The suggestion to be used.
	 */

	public ViewSuggestionAction(Context context, UserSession session, Camp camp, Suggestion suggestion)
			throws ClassNotFoundException, IOException {
		super(context, session);
		this.suggestion = suggestion;
		this.camp = camp;
		this.user = context.getUserManager().getUserByID(suggestion.getUserID());
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return The description.
	 */
	public String getDescription() {
		return String.format("%s - %s", user.getName(), suggestion.getDescription());
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public ViewHandler getNextView() {
		return new SuggestionView(context, session, camp, suggestion);
	}

	@Override
	/*
	 * Get the required permissions.
	 * 
	 * @return The required permissions.
	 */
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.MODIFY_CAMP, Permission.APPROVE_SUGGEST);
	}
}
