package boundary.action.actions;

import java.io.IOException;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.ModifyCampView;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;
import model.Suggestion;
import model.User;

public class ViewSuggestionAction extends Action {
	private final Suggestion suggestion;
	private final User user;
	private final Camp camp;

	public ViewSuggestionAction(Context context, UserSession session, Camp camp, Suggestion suggestion) throws ClassNotFoundException, IOException {
		super(context, session);
		this.suggestion = suggestion;
		this.camp = camp;
		this.user = context.getUserManager().getUserByID(suggestion.getUserID());
	}

	@Override
	public String getDescription() {
		return String.format("%s - %s", user.getUserID(), suggestion.getDescription());
	}

	@Override
	public void performAction() throws Exception {}
	
	@Override
	public ViewHandler getNextView() {
		return new ModifyCampView(context, session, camp, suggestion);
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.MODIFY_CAMP);
	}
}
