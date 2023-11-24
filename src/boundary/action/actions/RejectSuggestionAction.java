package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import main.Context;
import model.Permission;
import model.Suggestion;

public class RejectSuggestionAction extends Action {
	private final Suggestion suggestion;

	public RejectSuggestionAction(Context context, UserSession session, Suggestion suggestion) {
		super(context, session);
		this.suggestion = suggestion;
	}

	@Override
	public String getDescription() { return "Reject these Suggestions"; }

	@Override
	public void performAction() throws Exception {
		try {
			context.getSuggestionManager().deleteSuggestion(suggestion);
		} catch (Exception e) {
			context.print("I/O Error. Failed to delete suggestion!");
			return;
		}
		context.print("Suggestion has been removed.");
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.MODIFY_CAMP, Permission.APPROVE_SUGGEST);
	}
	
	@Override
	public ViewHandler getNextView() {
		return session.getViewStack().pop();
	}
}
