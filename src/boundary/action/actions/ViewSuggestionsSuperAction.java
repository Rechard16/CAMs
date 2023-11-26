package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.SuggestionListingView;
import control.login.UserSession;
import entity.model.Camp;
import entity.model.Permission;
import entity.model.Suggestion;
import main.Context;

public class ViewSuggestionsSuperAction extends Action {
	private final Camp camp;
	private List<Suggestion> suggestions;
	/*
	 * Constructor for ViewSuggestionsSuperAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 */

	public ViewSuggestionsSuperAction(Context context, UserSession session, Camp camp) {
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
		return "View all suggestions for camp";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		suggestions = context.getSuggestionManager()
				.getSuggestionsByCamp(camp.getID());
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
		return List.of(Permission.MODIFY_CAMP, Permission.APPROVE_SUGGEST);
	}

}
