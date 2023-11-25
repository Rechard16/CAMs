package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.SuggestionListingView;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;
import model.Suggestion;
/*
 * ViewSuggestionsAction is a class that is used to view suggestions.
 */

public class ViewSuggestionsAction extends Action {
	private final Camp camp;
	private List<Suggestion> suggestions;
	/*
	 * Constructor for ViewSuggestionsAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 */

	public ViewSuggestionsAction(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "View My Suggestions".
	 */
	public String getDescription() {
		return "View My Suggestions";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		suggestions = context.getSuggestionManager()
				.getSuggestionsByCamp(camp.getID(), session.getUser().getID());
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public ViewHandler getNextView() {
		return new SuggestionListingView(context, session, camp, suggestions);
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
