package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.View;
import boundary.login.UserSession;
import main.Context;
import model.Permission;
import model.Suggestion;

public class DeleteSuggestionAction extends Action {
	private final Suggestion suggestion;

	public DeleteSuggestionAction(Context context, UserSession session, Suggestion suggestion) {
		super(context, session);
		this.suggestion = suggestion;
	}

	@Override
	public String getDescription() {
		return "Delete this Suggestion";
	}

	@Override
	public void performAction() throws Exception {
		context.getSuggestionManager().deleteSuggestion(suggestion);
		context.print("Your suggestion was deleted!");
	}
	
	@Override
	public View getNextView() {
		return session.getViewStack().pop(2);
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.MODIFY_CAMP, Permission.SUGGEST_CAMP);
	}
	
	
}
