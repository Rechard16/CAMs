package boundary.action.actions;

import java.io.IOException;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.ModifySuggestionView;
import control.login.UserSession;
import entity.model.Camp;
import entity.model.Permission;
import entity.model.Suggestion;
import entity.model.SuggestionStatus;
import main.Context;

public class ModifySuggestionAction extends Action {
	private final Suggestion suggestion;
	private final Camp camp;
	/*
	 * Constructor for ModifySuggestionAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 * 
	 * @param suggestion The suggestion to be used.
	 */

	public ModifySuggestionAction(Context context, UserSession session, Camp camp, Suggestion suggestion)
			throws ClassNotFoundException, IOException {
		super(context, session);
		this.suggestion = suggestion;
		this.camp = camp;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return The description.
	 */
	public String getDescription() {
		String name = suggestion.getDescription();
		if (suggestion.getStatus() != SuggestionStatus.OPEN)
			name += String.format(" (%s)", suggestion.getStatus().name());
		return name;
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
		return new ModifySuggestionView(context, session, camp, suggestion);
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
